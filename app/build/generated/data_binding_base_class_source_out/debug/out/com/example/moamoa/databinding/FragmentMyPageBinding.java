// Generated by view binder compiler. Do not edit!
package com.example.moamoa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.moamoa.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMyPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView ID;

  @NonNull
  public final TextView area;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ConstraintLayout constraintLayout2;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ListView listView1;

  @NonNull
  public final ListView listView2;

  @NonNull
  public final ConstraintLayout myPage;

  @NonNull
  public final TextView nickname;

  @NonNull
  public final ImageView profileImage;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView5;

  private FragmentMyPageBinding(@NonNull ConstraintLayout rootView, @NonNull TextView ID,
      @NonNull TextView area, @NonNull ConstraintLayout constraintLayout,
      @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView3,
      @NonNull ImageView imageView4, @NonNull ListView listView1, @NonNull ListView listView2,
      @NonNull ConstraintLayout myPage, @NonNull TextView nickname, @NonNull ImageView profileImage,
      @NonNull TextView textView, @NonNull TextView textView3, @NonNull TextView textView5) {
    this.rootView = rootView;
    this.ID = ID;
    this.area = area;
    this.constraintLayout = constraintLayout;
    this.constraintLayout2 = constraintLayout2;
    this.imageView3 = imageView3;
    this.imageView4 = imageView4;
    this.listView1 = listView1;
    this.listView2 = listView2;
    this.myPage = myPage;
    this.nickname = nickname;
    this.profileImage = profileImage;
    this.textView = textView;
    this.textView3 = textView3;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ID;
      TextView ID = ViewBindings.findChildViewById(rootView, id);
      if (ID == null) {
        break missingId;
      }

      id = R.id.area;
      TextView area = ViewBindings.findChildViewById(rootView, id);
      if (area == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.constraintLayout2;
      ConstraintLayout constraintLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout2 == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.listView1;
      ListView listView1 = ViewBindings.findChildViewById(rootView, id);
      if (listView1 == null) {
        break missingId;
      }

      id = R.id.listView2;
      ListView listView2 = ViewBindings.findChildViewById(rootView, id);
      if (listView2 == null) {
        break missingId;
      }

      ConstraintLayout myPage = (ConstraintLayout) rootView;

      id = R.id.nickname;
      TextView nickname = ViewBindings.findChildViewById(rootView, id);
      if (nickname == null) {
        break missingId;
      }

      id = R.id.profile_image;
      ImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new FragmentMyPageBinding((ConstraintLayout) rootView, ID, area, constraintLayout,
          constraintLayout2, imageView3, imageView4, listView1, listView2, myPage, nickname,
          profileImage, textView, textView3, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
