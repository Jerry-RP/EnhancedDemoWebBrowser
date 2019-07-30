package sg.edu.rp.c346.enhanceddemowebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnLoadUrl;
    WebView wvMyPage;
EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText1);
        btnLoadUrl=findViewById(R.id.btnLoadUrl);
        wvMyPage=findViewById(R.id.webViewMyPage);
        wvMyPage.setWebViewClient(new WebViewClient());
        WebSettings testing=wvMyPage.getSettings();
        testing.setCacheMode(WebSettings.LOAD_NO_CACHE);
        testing.setAllowFileAccess(false);
        testing.setJavaScriptEnabled(true);

        testing.setBuiltInZoomControls(true);
        btnLoadUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code for the action
                if(ed1.getVisibility()==View.GONE){
                    ed1.setVisibility(View.VISIBLE);
                }else {
                    String url =  ed1.getText().toString();
                    if(!url.startsWith("https://")){
                     url="https://"+ed1.getText().toString();;
                    }





                    wvMyPage.loadUrl(url);
                    ed1.setVisibility(View.GONE);
                }

            }
        });

    }
}
