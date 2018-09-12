package com.example.srini.slugtutor;

import android.util.Log;

import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;


public class FirebaseService {

    // TODO: when a user signs out, set this ID to null
    private static String cachedUserId = null;

    public FirebaseService() {
    }

    public void setUpAccount() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            FirebaseDatabase.getInstance().getReference("users").child(user.getUid())
                    .child("name").setValue(name);
        }
    }

    public String getUserID() {
        if (FirebaseService.cachedUserId == null) {
            FirebaseService.cachedUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        }
        System.out.println(FirebaseService.cachedUserId);
        return FirebaseService.cachedUserId;
    }

    public void getUserClasses(final CallbackCourses callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("users")
                .child(getUserID()).child("courses");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Course> courses = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Course course = new Course();
                    course.setId(child.getKey());
                    for (DataSnapshot item : child.getChildren()) {
                        switch (item.getKey()) {
                            case "name":
                                course.setName(item.getValue().toString());
                                break;
                            case "description":
                                course.setDescription(item.getValue().toString());
                                break;
                            case "courseNum":
                                course.setCourseNum(item.getValue().toString());
                                break;
                            case "professor":
                                course.setProfessor(item.getValue().toString());
                                break;
                        }
                    }
                    courses.add(course);
                }

                callback.callback(courses);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getUserGroupListings(final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("users")
                .child(getUserID()).child("listings").child("groups");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getUserTutorListings(final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("users")
                .child(getUserID()).child("listings").child("tutors");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getUserStudentListings(final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("users")
                .child(getUserID()).child("listings").child("students");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getStudentListings(final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("listings")
                .child("students");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getCourseStudentListings(final Course course, final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("listings")
                .child("students");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, course, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getGroupListings(final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("listings")
                .child("groups");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getCourseGroupListings(final Course course, final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("listings")
                .child("groups");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, course, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getTutorListings(final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("listings")
                .child("tutors");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    public void getCourseTutorListings(final Course course, final CallbackListings callback) {
        DatabaseReference coursesReference = FirebaseDatabase.getInstance().getReference("listings")
                .child("tutors");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                processListings(dataSnapshot, course, callback);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        coursesReference.addListenerForSingleValueEvent(postListener);
    }

    private void processListings(DataSnapshot dataSnapshot, CallbackListings callback) {
        processListings(dataSnapshot, null, callback);
    }

    private void processListings(DataSnapshot dataSnapshot, Course course, CallbackListings callback) {
        List<Listing> listings = new ArrayList<>();
        outerLoop:
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            Listing listing = new Listing();
            Course courseListing;
            listing.setId(child.getKey());
            for (DataSnapshot item : child.getChildren()) {
                switch (item.getKey()) {
                    case "name":
                        listing.setName(item.getValue().toString());
                        break;
                    case "description":
                        listing.setDescription(item.getValue().toString());
                        break;
                    case "owner":
                        listing.setOwner(item.getValue().toString());
                        break;
                    case "course":
                        if (course == null) {
                            break;
                        }
                        System.out.println(course);
                        System.out.println(item.getValue());
                        courseListing = item.getValue(Course.class);
                        if (!courseListing.getCourseNum().equals(course.getCourseNum())) {
                         continue outerLoop;
                        } else {
                            listing.setCourse(courseListing);
                        }
                        break;
                }
            }
            listings.add(listing);
        }

        callback.callback(listings);
    }

    public void addCourse(Course course) {
        FirebaseDatabase.getInstance().getReference("users")
                .child(getUserID()).child("courses").child(course.getCourseNum())
                .setValue(new Course(
                        course.getName(),
                        course.getCourseNum(),
                        course.getProfessor(),
                        course.getDescription()));
    }

    public void addCourse(Course course, final Callback callback) {
        FirebaseDatabase.getInstance().getReference("users")
                .child(getUserID()).child("courses").child(course.getCourseNum())
                .setValue(new Course(
                        course.getName(),
                        course.getCourseNum(),
                        course.getProfessor(),
                        course.getDescription()), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        callback.callback();
                    }
                });
    }


    public void addStudentListing(String name, String description, Course course) {
        addListing("students", name, description, course);
    }

    public void addTutorListing(String name, String description, Course course) {
        addListing("tutors", name, description, course);
    }

    public void addGroupListing(String name, String description, Course course) {
        addListing("groups", name, description, course);
    }

    private void addListing(String type, String name, String description, Course course) {
        String uuid = UUID.randomUUID().toString();

        DatabaseReference userDatabaseReference = FirebaseDatabase.getInstance().getReference("users").child(getUserID())
                .child("listings").child(type).child(uuid);

        userDatabaseReference.child("name").setValue(name);
        userDatabaseReference.child("description").setValue(description);
        userDatabaseReference.child("owner").setValue(getUserID());
        userDatabaseReference.child("course").setValue(course);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("listings").child(type)
                .child(uuid);

        databaseReference.child("name").setValue(name);
        databaseReference.child("description").setValue(description);
        databaseReference.child("owner").setValue(getUserID());
        databaseReference.child("course").setValue(course);

    }

    private int conversationCounter;

    public void getConversations(final CallbackConversations callback) {
        DatabaseReference conversationsReference = FirebaseDatabase.getInstance().getReference("users")
                .child(getUserID()).child("conversations");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> names = new ArrayList<>();
                conversationCounter = 0;
                final long max = dataSnapshot.getChildrenCount();
                for (final DataSnapshot item : dataSnapshot.getChildren()) {
                    getName(item.getKey(), new CallbackName() {
                        @Override
                        public void callback(String name) {
                            conversationCounter++;
                            names.add(name + "," + item.getKey());
                            if (conversationCounter == max) {
                                callback.callback(names);
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        conversationsReference.addListenerForSingleValueEvent(postListener);
    }

    public void getName(String id, final CallbackName callback) {
        DatabaseReference nameReference = FirebaseDatabase.getInstance().getReference("users")
                .child(id).child("name");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                callback.callback(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        nameReference.addListenerForSingleValueEvent(postListener);
    }

    public DatabaseReference getConversationSocket(String otherUserID) {
        String conversationID = getConversationID(otherUserID, getUserID());
        if (conversationID == null) {
            return null;
        }

        DatabaseReference conversationSocket = FirebaseDatabase.getInstance().getReference("conversations")
                .child(conversationID);

        return conversationSocket;
    }

    public void sendMessage(String recipientID, String message) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US).format(new Date());

        System.out.println("test!");
        System.out.println(now);
        System.out.println(getConversationID(recipientID, getUserID()));

        String conversationID = getConversationID(recipientID, getUserID());
        if (conversationID == null) {
            return;
        }
        FirebaseDatabase.getInstance().getReference("users").child(getUserID())
                .child("conversations").child(recipientID).setValue(conversationID);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("conversations")
                .child(conversationID).child(now);

        databaseReference.child("message").setValue(message);
        databaseReference.child("owner").setValue(getUserID());
    }

    public boolean createConversation(String recipientID) {
        String conversationID = getConversationID(recipientID, getUserID());
        if (conversationID == null) {
            return false;
        }

        FirebaseDatabase.getInstance().getReference("users").child(getUserID())
                .child("conversations").child(recipientID).setValue(conversationID);

        FirebaseDatabase.getInstance().getReference("users").child(recipientID)
                .child("conversations").child(getUserID()).setValue(conversationID);

        return true;
    }

    private String getConversationID(String id1, String id2) {
       if (id1.compareTo(id2) > 0) {
           return id1 + id2;
       } else if (id1.compareTo(id2) < 0) {
           return id2 + id1;
       } else {
           return null;
       }

    }
}
