// Generated by view binder compiler. Do not edit!
package com.example.moamoa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.moamoa.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListviewBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView body1;

  @NonNull
  public final TextView charge;

  @NonNull
  public final TextView deadline;

  @NonNull
  public final ImageView mainImage;

  @NonNull
  public final TextView title;

  private ListviewBinding(@NonNull LinearLayout rootView, @NonNull TextView body1,
      @NonNull TextView charge, @NonNull TextView deadline, @NonNull ImageView mainImage,
      @NonNull TextView title) {
    this.rootView = rootView;
    this.body1 = body1;
    this.charge = charge;
    this.deadline = deadline;
    this.mainImage = mainImage;
    this.title = title;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.listview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.body_1;
      TextView body1 = ViewBindings.findChildViewById(rootView, id);
      if (body1 == null) {
        break missingId;
      }

      id = R.id.charge;
      TextView charge = ViewBindings.findChildViewById(rootView, id);
      if (charge == null) {
        break missingId;
      }

      id = R.id.deadline;
      TextView deadline = ViewBindings.findChildViewById(rootView, id);
      if (deadline == null) {
        break missingId;
      }

      id = R.id.mainImage;
      ImageView mainImage = ViewBindings.findChildViewById(rootView, id);
      if (mainImage == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new ListviewBinding((LinearLayout) rootView, body1, charge, deadline, mainImage,
          title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
