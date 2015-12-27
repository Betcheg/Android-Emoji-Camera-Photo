package betcheg.emojicameramontage;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import angtrim.com.fivestarslibrary.FiveStarsDialog;

public class MainActivity extends ActionBarActivity {

  private static final int CURRENT_PERMISSION = 0;
  private static int RESULT_LOAD_IMG = 1;
  String imgDecodableString;

  Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    this.setTitleColor(Color.WHITE);

    // Application logic start here

    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
    String restoredText = prefs.getString("howlong", null); // howlong = number of time the app has been opened

    if (restoredText != null) {
      FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this, "betcheg@gmail.com");

      fiveStarsDialog.setForceMode(true)
      .setUpperBound(3)
      .showAfter(0);
    } else {
      SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
      editor.putString("howlong", "ok");
      editor.apply();
    }


    button = (Button) findViewById(R.id.b_select);
    button.setTextColor(Color.parseColor("white"));
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        loadImagefromGallery();
      }
    });
  }

  public void loadImagefromGallery() {
    // Request permission (23+)
    if (ContextCompat.checkSelfPermission(this,
    Manifest.permission.READ_CONTACTS)
    != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this,
      new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, CURRENT_PERMISSION);
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {
      case CURRENT_PERMISSION: {
        if (grantResults.length > 0
        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

          // Create intent to Open Image applications like Gallery, Google Photos
          Intent galleryIntent = new Intent(Intent.ACTION_PICK,
          android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
          // Start the Intent
          startActivityForResult(galleryIntent, RESULT_LOAD_IMG);

        } else {
          Toast.makeText(MainActivity.this, "No permission?", Toast.LENGTH_LONG).show();
        }
      }
    }
  }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    try {
      // When an Image is picked
      if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
      && null != data) {
        // Get the Image from data

        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};

        // Get the cursor
        Cursor cursor = getContentResolver().query(selectedImage,
        filePathColumn, null, null, null);
        // Move to first row
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        imgDecodableString = cursor.getString(columnIndex);
        cursor.close();

        startEditing();


      } else {
        Toast.makeText(this, "You haven't picked Image",
        Toast.LENGTH_LONG).show();
      }
    } catch (Exception e) {
      Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
      .show();
    }

  }

  public void startEditing() {

    Intent intent = new Intent(this, betcheg.emojicameramontage.LetTheMontageBegin.class);
    intent.putExtra("image", imgDecodableString);
    startActivity(intent);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
