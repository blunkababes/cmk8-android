package com.blunka.mk8assistant.main.maps;

import android.os.Parcel;
import android.os.Parcelable;

import com.blunka.mk8assistant.data.courses.Course;
import com.blunka.mk8assistant.data.courses.CourseData;
import com.blunka.mk8assistant.data.courses.Cup;
import com.blunka.mk8assistant.shared.Model;

/**
 * Created by clocksmith on 9/8/14.
 */
public class MapsModel implements Parcelable, Model {
  private Cup mCup;
  private Course mCourse;

  public MapsModel() {
    this(CourseData.CUPS.get(0), CourseData.CUPS.get(0).getCourses().get(0));
  }

  public MapsModel(Cup cup, Course course) {
    mCup = cup;
    mCourse = course;
  }

  public Cup getCup() {
    return mCup;
  }

  public void setCup(Cup cup) {
    mCup = cup;
  }

  public Course getCourse() {
    return mCourse;
  }

  public void setCourse(Course course) {
    mCourse = course;
  }

  public MapsModel(Parcel in) {
    mCup = in.readParcelable(Cup.class.getClassLoader());
    mCourse = in.readParcelable(Course.class.getClassLoader());
  }

  @Override
  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeParcelable(mCup, flags);
    parcel.writeParcelable(mCourse, flags);
  }

  public static final Parcelable.Creator<MapsModel> CREATOR =
      new Parcelable.Creator<MapsModel>() {
        public MapsModel createFromParcel(Parcel in) {
          return new MapsModel(in);
        }

        public MapsModel[] newArray(int size) {
          return new MapsModel[size];
        }
      };

  @Override
  public int describeContents() {
    return 0;
  }
}
