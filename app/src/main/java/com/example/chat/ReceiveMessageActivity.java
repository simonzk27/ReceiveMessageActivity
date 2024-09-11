package com.example.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class ReceiveMessageActivity extends AppCompatActivity {

    private ArrayList<String> messageHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_message);
        Intent intent = getIntent();
        messageHistory = intent.getStringArrayListExtra("history");
        if (messageHistory == null) {
            messageHistory = new ArrayList<>();
        }
        TextView historyView = findViewById(R.id.historyView);
        historyView.setText(String.join("\n", messageHistory));
    }

    public void onSendMessage(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = "Persona2: " + messageView.getText().toString();
        messageHistory.add(messageText);
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putStringArrayListExtra("history", messageHistory);
        startActivity(intent);
    }
}
