package com.example.multimedia.mapasgoogle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class FragmentMessage extends DialogFragment {

    public static final String ARGUMENTO_TITLE = "TITLE";
    public static final String ARGUMENTO_FULL_SNIPPET = "FULL_SNIPPET";

    private String title;
    private String fullSnippet;

    public static FragmentMessage newInstance(String title, String fullSnippet){
        FragmentMessage fragmentMessage = new FragmentMessage();
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENTO_TITLE, title);
        bundle.putString(ARGUMENTO_FULL_SNIPPET, fullSnippet);
        fragmentMessage.setArguments(bundle);
        return fragmentMessage;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        title = args.getString(ARGUMENTO_TITLE);
        fullSnippet = args.getString(ARGUMENTO_FULL_SNIPPET);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(fullSnippet)
                .create();
        return dialog;
    }

}
