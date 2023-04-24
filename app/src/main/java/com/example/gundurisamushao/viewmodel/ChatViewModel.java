package com.example.gundurisamushao.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gundurisamushao.model.remote.chat.Message;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChatViewModel extends ViewModel {

    DatabaseReference mdb = FirebaseDatabase.getInstance().getReference();



    public void sendMessage(String email, String messagee){
        String dateTime = new SimpleDateFormat("dd-MM-yy HH:mma").format(Calendar.getInstance().getTime());
        mdb.child("Messages").push().setValue(new Message(email, messagee, dateTime)).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
    }






    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
