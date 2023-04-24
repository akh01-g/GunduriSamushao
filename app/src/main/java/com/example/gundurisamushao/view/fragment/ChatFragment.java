package com.example.gundurisamushao.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gundurisamushao.databinding.FragmentChatBinding;
import com.example.gundurisamushao.view.adapter.MessageAdapter;
import com.example.gundurisamushao.viewmodel.ChatViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChatFragment extends Fragment {

    private FragmentChatBinding binding;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private ChatViewModel chatViewModel = new ChatViewModel();

    private FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();

        setListeners();
        receiveMessages();
    }

    private void init(){
        user = auth.getCurrentUser();
        chatViewModel = new ViewModelProvider(this).get(ChatViewModel.class);

    }
    private void setListeners(){
        binding.btnSendMessage.setOnClickListener(view -> {
            String messagee = binding.etMessageBox.getEditText().getText().toString();
            chatViewModel.sendMessage(user.getEmail(), messagee);
            binding.etMessageBox.getEditText().setText("");

        });
    }

    private void receiveMessages(){
        chatViewModel.receiveMessages();
        setObservers();
    }

    private void setObservers(){
        chatViewModel.messageLiveData.observe(getViewLifecycleOwner(), messages -> {
            MessageAdapter adapter = new MessageAdapter(messages);
            binding.rvMessage.setAdapter(adapter);
            binding.rvMessage.scrollToPosition(messages.size() - 1);
        });
    }
}

