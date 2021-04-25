package com.flash.apps.deepen_iterable;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterableInAppManager;
import com.iterable.iterableapi.IterableInAppMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button confirm;
    Button trackEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirm = findViewById(R.id.initSDK);
        trackEvent = findViewById(R.id.trackEvent);

        //Update User method
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final JSONObject datafields = new JSONObject();

                try {
                    datafields.put("firstName", "Deepen");
                    datafields.put("isRegisteredUser", true);
                    datafields.put("SA_User_Test_Key", "completed");

                    System.out.println("Iterable - Fiels added");
                } catch (JSONException e) {
                    System.out.println("Iterable - Exception");
                    e.printStackTrace();
                }
                IterableApi.getInstance().updateUser(datafields);

            }

        });

        //Track Event: mobileSATestEvent
        trackEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final JSONObject datafields = new JSONObject();

                try {
                    datafields.put("platform", "Android");
                    datafields.put("isTestEvent", true);
                    datafields.put("url", "https://iterable.com/sa-test/deepen");
                    datafields.put("secret_code_key", "Code_123");

                    System.out.println("Iterable - Fiels added for event tracking");
                } catch (JSONException e) {
                    System.out.println("Iterable - Exception for event tracking");
                    e.printStackTrace();
                }

                IterableApi.getInstance().track("mobileSATestEvent", datafields);
                System.out.println("Iterable - Event tracked");
            }
        });

        //Showing in-app messages
        // Get the in-app messages list
        IterableInAppManager inAppManager = IterableApi.getInstance().getInAppManager();
        List <IterableInAppMessage> messages = inAppManager.getMessages();

        // Show an in-app message
        for (IterableInAppMessage message : messages)
        inAppManager.showMessage(message);
        System.out.println("Iterable - In-app message shown");

    }
}
