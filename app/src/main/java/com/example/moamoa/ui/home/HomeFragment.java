package com.example.moamoa.ui.home;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moamoa.R;
import com.example.moamoa.Retrofit_Function;
import com.example.moamoa.databinding.FragmentHomeBinding;
import com.example.moamoa.ui.category.CategoryActivity;
import com.example.moamoa.ui.category.CategoryAdapter_my;
import com.example.moamoa.ui.category.CategoryData;
import com.example.moamoa.ui.formdetail.FormdetailActivity;
import com.example.moamoa.ui.notifications.NotificationsActivity;
import com.example.moamoa.ui.search.SearchActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private ArrayList<homelist_data> homelist[]=new ArrayList[5];
    private homelist_adapter homelistAdapter[]=new homelist_adapter[5];
    private RecyclerView[] recyclerView = new RecyclerView[5];
    private FirebaseDatabase mDatabase;
    private TextView[] btn_c = new TextView[5];
    private CategoryAdapter_my categoryAdapter_my;
    private GridView gridViews;
    boolean[] my_list = new boolean[15];

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mDatabase = FirebaseDatabase.getInstance();
        Query reference[] = new Query[5];

        categoryAdapter_my = new CategoryAdapter_my();
        gridViews = (GridView) root.findViewById(R.id.home_my_category);
        initmylist();
        /* 카테고리 grid 출력 */
        gridViews.setAdapter(categoryAdapter_my);

        /* 카테고리 Recyclerview 설정 */
        recyclerView[0] = (RecyclerView) root.findViewById(R.id.listview0);
        recyclerView[1] = (RecyclerView) root.findViewById(R.id.listview1);
        recyclerView[2] = (RecyclerView) root.findViewById(R.id.listview2);
        recyclerView[3] = (RecyclerView) root.findViewById(R.id.listview3);
        //recyclerView[4] = (RecyclerView) root.findViewById(R.id.listview4);
        reference[0] = mDatabase.getReference().child("form").orderByChild("deadline").limitToFirst(10);    //마감임박
        reference[1] = mDatabase.getReference().child("form").orderByChild("parti_num").limitToLast(10);    //인기별
        reference[2] = mDatabase.getReference().child("form").orderByChild("today").limitToFirst(10);       //신규
        reference[3] = mDatabase.getReference().child("form").orderByChild("today").limitToFirst(10);       //나의 관심 카테고리
        //reference[2] = mDatabase.getReference().child("form").orderByChild("today").limitToFirst(10);       //최근 본 게시글



        /* 전체보기 버튼 */
        btn_c[0] = (TextView) root.findViewById(R.id.btn_ctgy0);
        btn_c[1] = (TextView) root.findViewById(R.id.btn_ctgy1);
        btn_c[2] = (TextView) root.findViewById(R.id.btn_ctgy2);
        btn_c[3] = (TextView) root.findViewById(R.id.btn_ctgy3);   
        //btn_c[4] = (TextView) root.findViewById(R.id.btn_ctgy4);


        /* 각 listview에 상세 페이지 이동 연동 */
        for(int i=0;i<4;i++){
            homelist[i]=new ArrayList<>();
            homelistAdapter[i] = new homelist_adapter(homelist[i]);
            int finalI = i;
            homelistAdapter[i].setOnItemClickListener(new homelist_adapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    String FID   = homelist[finalI].get(position).getFID();
                    String UID   = homelist[finalI].get(position).getUID();
                    //인텐트 선언 및 정의
                    Intent intent = new Intent(getContext(), FormdetailActivity.class);
                    //입력한 input값을 intent로 전달한다.
                    intent.putExtra("FID", FID);
                    intent.putExtra(("UID_dash"),UID);
                    //액티비티 이동
                    startActivity(intent);
                }
            });
        }

        /* 각 레퍼런스 데이터 불러오기 */
        GetOrderByreference(reference[0],0);
        GetOrderByreference(reference[1],1);
        GetOrderByreference(reference[2],2);

        /* 전체보기 버튼 클릭 시 CategoryActivity 이동 설정 */
        for(int i=0;i<4;i++){
            btn_c[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Retrofit_Function.category();
                    Intent intent = new Intent(getActivity(), CategoryActivity.class);
                    startActivity(intent);
                }
            });
        }

        /* 상단의 툴바 검색 버튼 설정 */
        root.findViewById(R.id.search_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        /* 상단의 툴바 알림 버튼 설정 */
        root.findViewById(R.id.notification_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotificationsActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    /* Adapter에 넣을 Data 입력 */
    public void InitializeFormData(int i,String img, String title, String UID, String mans, String FID, String category)
    {
        homelist_data tmp = new homelist_data();

        Resources res = getResources();
        String[] cat = res.getStringArray(R.array.category);
        category=cat[Integer.parseInt(category)];

        tmp.setImgName(img);
        tmp.setTitle(title);
        tmp.setNick(UID);
        tmp.setMans(mans);
        tmp.setFID(FID);
        tmp.setUID(UID);
        tmp.setCategory(category);
        homelist[i].add(tmp);

    }
    /* 마감/인기/신규순 리스트 출력 */
    public void GetOrderByreference(Query reference, int i){
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    homelist[i].clear();
                    DataSnapshot result = task.getResult();
                    for (DataSnapshot fileSnapshot : result.getChildren() ) {
                        String Key = fileSnapshot.getKey();
                        String subject = fileSnapshot.child("subject").getValue().toString();
                        String max_count = fileSnapshot.child("max_count").getValue().toString();
                        String UID = fileSnapshot.child("UID_dash").getValue().toString();
                        String parti_num = fileSnapshot.child("parti_num").getValue().toString();
                        String image =  fileSnapshot.child("image").getValue().toString();
                        String category = fileSnapshot.child("category_text").getValue().toString();
                        InitializeFormData(i,image,subject,UID,parti_num+"/"+max_count,Key,category);
                    }
                }
                recyclerView[i].setAdapter(homelistAdapter[i]);
                recyclerView[i].setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL, false));
            }
        });
    }
    /* 관심카테고리 출력*/
    public void GetMyReference( int i){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int x=2;x<my_list.length;x++){
            if(my_list[x]) list.add(x);
        }
        Query reference = FirebaseDatabase.getInstance().getReference().child("form");
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    homelist[i].clear();
                    DataSnapshot result = task.getResult();
                    int count=0;
                    for (DataSnapshot fileSnapshot : result.getChildren() ) {
                        String category = fileSnapshot.child("category_text").getValue().toString();
                        int temp = Integer.parseInt(category);
                        if(list.contains(temp) && count<10){
                            String Key = fileSnapshot.getKey();
                            String subject = fileSnapshot.child("subject").getValue().toString();
                            String max_count = fileSnapshot.child("max_count").getValue().toString();
                            String UID = fileSnapshot.child("UID_dash").getValue().toString();
                            String parti_num = fileSnapshot.child("parti_num").getValue().toString();
                            String image =  fileSnapshot.child("image").getValue().toString();
                            InitializeFormData(i,image,subject,UID,parti_num+"/"+max_count,Key,category);
                            count++;
                        }

                    }
                }
                recyclerView[i].setAdapter(homelistAdapter[i]);
                recyclerView[i].setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL, false));
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    /* mylist 배열 초기화 */
    public void initmylist(){
        for(int i=0;i<15;i++){
            my_list[i]=false;
        }
        mDatabase.getReference().child("users").child(currentUser.getUid()).child("mycategory").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    DataSnapshot result = task.getResult();
                    if(result!=null){
                        for (DataSnapshot fileSnapshot : result.getChildren() ) {
                            String temp = fileSnapshot.getValue().toString();
                            int x = Integer.parseInt(temp);
                            my_list[x]=true;
                        }
                    }
                    setmycategory();
                    GetMyReference(3);
                }
            }
        });
    }
    /* mylist에 true값을 가진 요소로 카테고리 태그 출력*/
    public void setmycategory(){
        categoryAdapter_my.isEmpty();
        Resources res = getResources();
        String[] cat = res.getStringArray(R.array.category);
        gridViews.removeAllViewsInLayout();
        categoryAdapter_my.clear();
        int x = 0;
        for (int i=0;i< cat.length;i++) {
            String name = cat[i];
            if(my_list[i]){
                categoryAdapter_my.addItem(new CategoryData(i+"",name));
            }
        }
        categoryAdapter_my.notifyDataSetChanged();
    }
}