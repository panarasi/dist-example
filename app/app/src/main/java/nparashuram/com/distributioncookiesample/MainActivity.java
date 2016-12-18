package nparashuram.com.distributioncookiesample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String URL = "https://panarasi.github.io/dist-example/index.html#show";
    //public static final String URL = "http://localhost:8080/index.html#show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        if (intent != null) {
            Uri uri = intent.getData();

            if (uri != null && "dist-demo".equals(uri.getScheme())) {
                TextView result = (TextView) findViewById(R.id.result);
                result.setText(uri.getQueryParameter("data"));
            }
        }

    }

    public void onButtonClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(URL));
        startActivity(i);
        finish();
    }
}
