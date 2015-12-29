package betcheg.emojicameramontage;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import com.navdrawer.SimpleSideDrawer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
* Created by bastien on 28/10/15.
*/
public class LetTheMontageBegin extends ActionBarActivity {


    int currentIdTable;
    int lastIdImage = 0;
    long lastclic = 0;
    int lastId = 0;
    int currentNumberOfImages = 0;

    String imageString;
    Button addMontage;
    Button save;
    TextView imagecreated;

// Auto-generated table
  long[] idTable = {
    R.drawable.aemoji1f47d,
    R.drawable.aemoji1f47f,
    R.drawable.aemoji1f4a9,
    R.drawable.aemoji1f600,
    R.drawable.aemoji1f601,
    R.drawable.aemoji1f602,
    R.drawable.aemoji1f603,
    R.drawable.aemoji1f604,
    R.drawable.aemoji1f605,
    R.drawable.aemoji1f606,
    R.drawable.aemoji1f607,
    R.drawable.aemoji1f608,
    R.drawable.aemoji1f609,
    R.drawable.aemoji1f60a,
    R.drawable.aemoji1f60b,
    R.drawable.aemoji1f60c,
    R.drawable.aemoji1f60d,
    R.drawable.aemoji1f60e,
    R.drawable.aemoji1f60f,
    R.drawable.aemoji1f610,
    R.drawable.aemoji1f611,
    R.drawable.aemoji1f612,
    R.drawable.aemoji1f613,
    R.drawable.aemoji1f614,
    R.drawable.aemoji1f615,
    R.drawable.aemoji1f616,
    R.drawable.aemoji1f617,
    R.drawable.aemoji1f618,
    R.drawable.aemoji1f619,
    R.drawable.aemoji1f61a,
    R.drawable.aemoji1f61b,
    R.drawable.aemoji1f61c,
    R.drawable.aemoji1f61d,
    R.drawable.aemoji1f61e,
    R.drawable.aemoji1f61f,
    R.drawable.aemoji1f620,
    R.drawable.aemoji1f621,
    R.drawable.aemoji1f622,
    R.drawable.aemoji1f623,
    R.drawable.aemoji1f624,
    R.drawable.aemoji1f625,
    R.drawable.aemoji1f626,
    R.drawable.aemoji1f627,
    R.drawable.aemoji1f628,
    R.drawable.aemoji1f629,
    R.drawable.aemoji1f62a,
    R.drawable.aemoji1f62b,
    R.drawable.aemoji1f62c,
    R.drawable.aemoji1f62d,
    R.drawable.aemoji1f62e,
    R.drawable.aemoji1f62f,
    R.drawable.aemoji1f630,
    R.drawable.aemoji1f631,
    R.drawable.aemoji1f632,
    R.drawable.aemoji1f633,
    R.drawable.aemoji1f634,
    R.drawable.aemoji1f635,
    R.drawable.aemoji1f636,
    R.drawable.aemoji1f637,
    R.drawable.aemoji1f641,
    R.drawable.aemoji1f642,
    R.drawable.aemoji1f643,
    R.drawable.aemoji1f644,
    R.drawable.aemoji1f910,
    R.drawable.aemoji1f911,
    R.drawable.aemoji1f912,
    R.drawable.aemoji1f913,
    R.drawable.aemoji1f914,
    R.drawable.aemoji1f915,
    R.drawable.aemoji1f917,
    R.drawable.aemoji2639,
    R.drawable.aemoji263a,
    R.drawable.aemojiz1f525,
  };

// Auto-generated buttons
  Button aemoji1f47d;
  Button aemoji1f47f;
  Button aemoji1f4a9;
  Button aemoji1f600;
  Button aemoji1f601;
  Button aemoji1f602;
  Button aemoji1f603;
  Button aemoji1f604;
  Button aemoji1f605;
  Button aemoji1f606;
  Button aemoji1f607;
  Button aemoji1f608;
  Button aemoji1f609;
  Button aemoji1f60a;
  Button aemoji1f60b;
  Button aemoji1f60c;
  Button aemoji1f60d;
  Button aemoji1f60e;
  Button aemoji1f60f;
  Button aemoji1f610;
  Button aemoji1f611;
  Button aemoji1f612;
  Button aemoji1f613;
  Button aemoji1f614;
  Button aemoji1f615;
  Button aemoji1f616;
  Button aemoji1f617;
  Button aemoji1f618;
  Button aemoji1f619;
  Button aemoji1f61a;
  Button aemoji1f61b;
  Button aemoji1f61c;
  Button aemoji1f61d;
  Button aemoji1f61e;
  Button aemoji1f61f;
  Button aemoji1f620;
  Button aemoji1f621;
  Button aemoji1f622;
  Button aemoji1f623;
  Button aemoji1f624;
  Button aemoji1f625;
  Button aemoji1f626;
  Button aemoji1f627;
  Button aemoji1f628;
  Button aemoji1f629;
  Button aemoji1f62a;
  Button aemoji1f62b;
  Button aemoji1f62c;
  Button aemoji1f62d;
  Button aemoji1f62e;
  Button aemoji1f62f;
  Button aemoji1f630;
  Button aemoji1f631;
  Button aemoji1f632;
  Button aemoji1f633;
  Button aemoji1f634;
  Button aemoji1f635;
  Button aemoji1f636;
  Button aemoji1f637;
  Button aemoji1f641;
  Button aemoji1f642;
  Button aemoji1f643;
  Button aemoji1f644;
  Button aemoji1f910;
  Button aemoji1f911;
  Button aemoji1f912;
  Button aemoji1f913;
  Button aemoji1f914;
  Button aemoji1f915;
  Button aemoji1f917;
  Button aemoji2639;
  Button aemoji263a;
  Button aemojiz1f525;
// End

  ImageView tmp;
  SimpleSideDrawer slide;
  SeekBar seekbarSize;
  SeekBar seekbarRotation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getSupportActionBar().hide();


    this.setContentView(R.layout.editor);
    slide = new SimpleSideDrawer(this);
    slide.setLeftBehindContentView(R.layout.emojilist);

    Intent intent = getIntent();
    imageString = intent.getStringExtra("image");

    // UI Buttons
    addMontage = (Button) findViewById(R.id.b_addmontage);
    addMontage.setTextColor(Color.parseColor("white"));
    save = (Button) findViewById(R.id.b_savemontage);
    save.setTextColor(Color.parseColor("white"));
    imagecreated = (TextView) findViewById(R.id.t_imagecreated);
    imagecreated.setTextColor(Color.parseColor("white"));
    showMenu();

    // Montage Buttons -- Auto-generated
    aemoji1f47d = (Button) findViewById(R.id.b_aemoji1f47d);
    aemoji1f47f = (Button) findViewById(R.id.b_aemoji1f47f);
    aemoji1f4a9 = (Button) findViewById(R.id.b_aemoji1f4a9);
    aemoji1f600 = (Button) findViewById(R.id.b_aemoji1f600);
    aemoji1f601 = (Button) findViewById(R.id.b_aemoji1f601);
    aemoji1f602 = (Button) findViewById(R.id.b_aemoji1f602);
    aemoji1f603 = (Button) findViewById(R.id.b_aemoji1f603);
    aemoji1f604 = (Button) findViewById(R.id.b_aemoji1f604);
    aemoji1f605 = (Button) findViewById(R.id.b_aemoji1f605);
    aemoji1f606 = (Button) findViewById(R.id.b_aemoji1f606);
    aemoji1f607 = (Button) findViewById(R.id.b_aemoji1f607);
    aemoji1f608 = (Button) findViewById(R.id.b_aemoji1f608);
    aemoji1f609 = (Button) findViewById(R.id.b_aemoji1f609);
    aemoji1f60a = (Button) findViewById(R.id.b_aemoji1f60a);
    aemoji1f60b = (Button) findViewById(R.id.b_aemoji1f60b);
    aemoji1f60c = (Button) findViewById(R.id.b_aemoji1f60c);
    aemoji1f60d = (Button) findViewById(R.id.b_aemoji1f60d);
    aemoji1f60e = (Button) findViewById(R.id.b_aemoji1f60e);
    aemoji1f60f = (Button) findViewById(R.id.b_aemoji1f60f);
    aemoji1f610 = (Button) findViewById(R.id.b_aemoji1f610);
    aemoji1f611 = (Button) findViewById(R.id.b_aemoji1f611);
    aemoji1f612 = (Button) findViewById(R.id.b_aemoji1f612);
    aemoji1f613 = (Button) findViewById(R.id.b_aemoji1f613);
    aemoji1f614 = (Button) findViewById(R.id.b_aemoji1f614);
    aemoji1f615 = (Button) findViewById(R.id.b_aemoji1f615);
    aemoji1f616 = (Button) findViewById(R.id.b_aemoji1f616);
    aemoji1f617 = (Button) findViewById(R.id.b_aemoji1f617);
    aemoji1f618 = (Button) findViewById(R.id.b_aemoji1f618);
    aemoji1f619 = (Button) findViewById(R.id.b_aemoji1f619);
    aemoji1f61a = (Button) findViewById(R.id.b_aemoji1f61a);
    aemoji1f61b = (Button) findViewById(R.id.b_aemoji1f61b);
    aemoji1f61c = (Button) findViewById(R.id.b_aemoji1f61c);
    aemoji1f61d = (Button) findViewById(R.id.b_aemoji1f61d);
    aemoji1f61e = (Button) findViewById(R.id.b_aemoji1f61e);
    aemoji1f61f = (Button) findViewById(R.id.b_aemoji1f61f);
    aemoji1f620 = (Button) findViewById(R.id.b_aemoji1f620);
    aemoji1f621 = (Button) findViewById(R.id.b_aemoji1f621);
    aemoji1f622 = (Button) findViewById(R.id.b_aemoji1f622);
    aemoji1f623 = (Button) findViewById(R.id.b_aemoji1f623);
    aemoji1f624 = (Button) findViewById(R.id.b_aemoji1f624);
    aemoji1f625 = (Button) findViewById(R.id.b_aemoji1f625);
    aemoji1f626 = (Button) findViewById(R.id.b_aemoji1f626);
    aemoji1f627 = (Button) findViewById(R.id.b_aemoji1f627);
    aemoji1f628 = (Button) findViewById(R.id.b_aemoji1f628);
    aemoji1f629 = (Button) findViewById(R.id.b_aemoji1f629);
    aemoji1f62a = (Button) findViewById(R.id.b_aemoji1f62a);
    aemoji1f62b = (Button) findViewById(R.id.b_aemoji1f62b);
    aemoji1f62c = (Button) findViewById(R.id.b_aemoji1f62c);
    aemoji1f62d = (Button) findViewById(R.id.b_aemoji1f62d);
    aemoji1f62e = (Button) findViewById(R.id.b_aemoji1f62e);
    aemoji1f62f = (Button) findViewById(R.id.b_aemoji1f62f);
    aemoji1f630 = (Button) findViewById(R.id.b_aemoji1f630);
    aemoji1f631 = (Button) findViewById(R.id.b_aemoji1f631);
    aemoji1f632 = (Button) findViewById(R.id.b_aemoji1f632);
    aemoji1f633 = (Button) findViewById(R.id.b_aemoji1f633);
    aemoji1f634 = (Button) findViewById(R.id.b_aemoji1f634);
    aemoji1f635 = (Button) findViewById(R.id.b_aemoji1f635);
    aemoji1f636 = (Button) findViewById(R.id.b_aemoji1f636);
    aemoji1f637 = (Button) findViewById(R.id.b_aemoji1f637);
    aemoji1f641 = (Button) findViewById(R.id.b_aemoji1f641);
    aemoji1f642 = (Button) findViewById(R.id.b_aemoji1f642);
    aemoji1f643 = (Button) findViewById(R.id.b_aemoji1f643);
    aemoji1f644 = (Button) findViewById(R.id.b_aemoji1f644);
    aemoji1f910 = (Button) findViewById(R.id.b_aemoji1f910);
    aemoji1f911 = (Button) findViewById(R.id.b_aemoji1f911);
    aemoji1f912 = (Button) findViewById(R.id.b_aemoji1f912);
    aemoji1f913 = (Button) findViewById(R.id.b_aemoji1f913);
    aemoji1f914 = (Button) findViewById(R.id.b_aemoji1f914);
    aemoji1f915 = (Button) findViewById(R.id.b_aemoji1f915);
    aemoji1f917 = (Button) findViewById(R.id.b_aemoji1f917);
    aemoji2639 = (Button) findViewById(R.id.b_aemoji2639);
    aemoji263a = (Button) findViewById(R.id.b_aemoji263a);
    aemojiz1f525 = (Button) findViewById(R.id.b_aemojiz1f525);
    // End of auto-generation

    seekbarSize = (SeekBar) findViewById(R.id.seekbarSize);
    seekbarRotation = (SeekBar) findViewById(R.id.seekbarRotation);


    ImageView imgView = (ImageView) findViewById(R.id.imgView);
    imgView.setImageBitmap(decodeSampledBitmapFromResource(imageString)); // Get the image previously selected by the user

    imgView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        seekbarSize.setVisibility(View.INVISIBLE);
        seekbarRotation.setVisibility(View.INVISIBLE);
        if (!slide.isClosed()) {
          slide.close();
        }
        showMenu();
      }


    });


    save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Make everything disappear, screen, make everything appear
        imagecreated.setVisibility(View.VISIBLE);
        seekbarSize.setVisibility(View.GONE);
        seekbarRotation.setVisibility(View.GONE);
        addMontage.setVisibility(View.GONE);
        save.setVisibility(View.GONE);

        captureScreen();

        imagecreated.setVisibility(View.INVISIBLE);

        currentNumberOfImages = 0;
        showMenu();

      }


    });


    seekbarSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
        tmp = (ImageView) findViewById(lastIdImage);
        tmp.requestLayout();
        tmp.getLayoutParams().height = ((500 * progresValue) / 100) + 30;
        tmp.getLayoutParams().width = ((500 * progresValue) / 100) + 30;
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }


    });

    seekbarRotation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      int progress = 0;
      @Override
      public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
        tmp = (ImageView) findViewById(lastIdImage);
        tmp.requestLayout();
        tmp.setseekbarRotation((int) ((progresValue * 3.6) - 180));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }


    });


    addMontage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        seekbarSize.setVisibility(View.INVISIBLE);
        seekbarRotation.setVisibility(View.INVISIBLE);
        slide.toggleDrawer();
      }


    });

    // AUTO-GENERATED BUTTON-LISTENER

    aemoji1f47d.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f47d);
      }
    });



    aemoji1f47f.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f47f);
      }
    });



    aemoji1f4a9.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f4a9);
      }
    });



    aemoji1f600.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f600);
      }
    });



    aemoji1f601.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f601);
      }
    });



    aemoji1f602.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f602);
      }
    });



    aemoji1f603.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f603);
      }
    });



    aemoji1f604.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f604);
      }
    });



    aemoji1f605.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f605);
      }
    });



    aemoji1f606.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f606);
      }
    });



    aemoji1f607.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f607);
      }
    });



    aemoji1f608.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f608);
      }
    });



    aemoji1f609.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f609);
      }
    });



    aemoji1f60a.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f60a);
      }
    });



    aemoji1f60b.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f60b);
      }
    });



    aemoji1f60c.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f60c);
      }
    });



    aemoji1f60d.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f60d);
      }
    });



    aemoji1f60e.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f60e);
      }
    });



    aemoji1f60f.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f60f);
      }
    });



    aemoji1f610.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f610);
      }
    });



    aemoji1f611.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f611);
      }
    });



    aemoji1f612.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f612);
      }
    });



    aemoji1f613.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f613);
      }
    });



    aemoji1f614.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f614);
      }
    });



    aemoji1f615.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f615);
      }
    });



    aemoji1f616.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f616);
      }
    });



    aemoji1f617.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f617);
      }
    });



    aemoji1f618.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f618);
      }
    });



    aemoji1f619.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f619);
      }
    });



    aemoji1f61a.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f61a);
      }
    });



    aemoji1f61b.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f61b);
      }
    });



    aemoji1f61c.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f61c);
      }
    });



    aemoji1f61d.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f61d);
      }
    });



    aemoji1f61e.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f61e);
      }
    });



    aemoji1f61f.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f61f);
      }
    });



    aemoji1f620.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f620);
      }
    });



    aemoji1f621.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f621);
      }
    });



    aemoji1f622.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f622);
      }
    });



    aemoji1f623.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f623);
      }
    });



    aemoji1f624.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f624);
      }
    });



    aemoji1f625.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f625);
      }
    });



    aemoji1f626.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f626);
      }
    });



    aemoji1f627.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f627);
      }
    });



    aemoji1f628.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f628);
      }
    });



    aemoji1f629.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f629);
      }
    });



    aemoji1f62a.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f62a);
      }
    });



    aemoji1f62b.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f62b);
      }
    });



    aemoji1f62c.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f62c);
      }
    });



    aemoji1f62d.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f62d);
      }
    });



    aemoji1f62e.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f62e);
      }
    });



    aemoji1f62f.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f62f);
      }
    });



    aemoji1f630.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f630);
      }
    });



    aemoji1f631.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f631);
      }
    });



    aemoji1f632.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f632);
      }
    });



    aemoji1f633.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f633);
      }
    });



    aemoji1f634.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f634);
      }
    });



    aemoji1f635.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f635);
      }
    });



    aemoji1f636.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f636);
      }
    });



    aemoji1f637.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f637);
      }
    });



    aemoji1f641.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f641);
      }
    });



    aemoji1f642.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f642);
      }
    });



    aemoji1f643.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f643);
      }
    });



    aemoji1f644.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f644);
      }
    });



    aemoji1f910.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f910);
      }
    });



    aemoji1f911.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f911);
      }
    });



    aemoji1f912.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f912);
      }
    });


    aemoji1f913.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f913);
      }
    });



    aemoji1f914.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f914);
      }
    });



    aemoji1f915.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f915);
      }
    });



    aemoji1f917.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji1f917);
      }
    });



    aemoji2639.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji2639);
      }
    });



    aemoji263a.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemoji263a);
      }
    });



    aemojiz1f525.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        touchedImage(R.drawable.aemojiz1f525);
      }
    });
    // END OF AUTO-GENERATED PART
  }

  @Override
  public void onBackPressed() {
    if (currentNumberOfImages != 0) {
      new AlertDialog.Builder(LetTheMontageBegin.this)
      .setTitle("WARNING")
      .setMessage("THIS CHEF-D-OEUVRE WILL BE DESTROYED!")
      .setNegativeButton(android.R.string.cancel, null) // dismisses by default
      .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          finish();
        }
      })
      .create()
      .show();
    } else finish();
  }

  void hideMenu() {
    addMontage.setVisibility(View.INVISIBLE);
    save.setVisibility(View.INVISIBLE);
  }


  void showMenu() {
    addMontage.setVisibility(View.VISIBLE);
    if(currentNumberOfImages != 0) save.setVisibility(View.VISIBLE);
    else save.setVisibility(View.INVISIBLE);
    addMontage.bringToFront();
    save.bringToFront();
  }


  void touchedImage(int id) {

    currentNumberOfImages++;
    currentIdTable = 1;

    for (int i = 0; i < idTable.length; i++) {
      if (idTable[i] == id) currentIdTable = i;
    }

    slide.toggleDrawer();

    final ImageView iv = new ImageView(getApplicationContext());
    iv.setImageResource(id);
    iv.setClickable(true);
    iv.setId(View.generateViewId());

    RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
    RelativeLayout.LayoutParams.WRAP_CONTENT,
    RelativeLayout.LayoutParams.WRAP_CONTENT);

    lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    rl.addView(iv, lp);

    showMenu();

    iv.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View arg0, MotionEvent arg1) {

        int currentX = (int) arg1.getRawX();
        int currentY = (int) arg1.getRawY();

        if (arg1.getAction() == MotionEvent.ACTION_MOVE) {

          iv.setX(currentX - iv.getWidth() / 2);
          iv.setY(currentY - iv.getHeight() / 2);
          seekbarRotation.bringToFront();
          seekbarSize.bringToFront();
          lastclic = 0;

        } else if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
          lastIdImage = iv.getId();
          seekbarSize.setVisibility(View.VISIBLE);
          seekbarRotation.setVisibility(View.VISIBLE);
          hideMenu();
          iv.bringToFront();

          if (lastId == iv.getId() && System.currentTimeMillis() - lastclic < 500) {
            iv.setVisibility(View.GONE);
            seekbarSize.setVisibility(View.INVISIBLE);
            seekbarRotation.setVisibility(View.INVISIBLE);
            if(currentNumberOfImages != 0) currentNumberOfImages--;
            showMenu();
          }

          lastclic = System.currentTimeMillis();


        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
          showMenu();
        }

        lastId = iv.getId();
        return true;
      }
    });
  }

  private void captureScreen() {
    Date now = new Date();
    now.getYear();
    now.getMonth();
    now.getDay();

    View v = findViewById(R.id.rl);
    v.setDrawingCacheEnabled(true);
    Bitmap bitmap = v.getDrawingCache();
    String dest = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
    + File.separator + "Camera" + File.separator + "EMOJI_" +
    now.getDay() + "-" + now.getMonth() + "-" + now.getYear() + "_" + now.getHours() + now.getMinutes() + now.getSeconds() + ".jpg";
    File file = new File(dest);
    try {
      FileOutputStream stream = new FileOutputStream(file);
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
      stream.flush();
      stream.close();
      Toast.makeText(getApplicationContext(), "Saved !", Toast.LENGTH_SHORT).show();
    } catch (IOException e) {
      Toast.makeText(getApplicationContext(), "An error occured", Toast.LENGTH_LONG).show();
    } finally {
      v.setDrawingCacheEnabled(false);
    }

    // Scan the image to make it appear in gallery
    MediaScannerConnection.scanFile(this, new String[]{file.getPath()}, new String[]{"image/jpeg"}, null);
  }

    
  public Bitmap decodeSampledBitmapFromResource(String path) {

    Display display = getWindowManager().getDefaultDisplay();
    int currentWidth = display.getWidth();
    int currentHeight = display.getHeight();

    int gradient = currentWidth / currentHeight;
    int reqHeight = 1024;
    int reqWidth = gradient* reqHeight;



    // First decode with inJustDecodeBounds=true to check dimensions
    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(path, options);

    // Calculate inSampleSize
    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

    // Decode bitmap with inSampleSize set
    options.inJustDecodeBounds = false;
    return ExifUtil.rotateBitmap(path, BitmapFactory.decodeFile(path, options));
  }

  public static int calculateInSampleSize(
          BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

      final int halfHeight = height / 2;
      final int halfWidth = width / 2;

      // Calculate the largest inSampleSize value that is a power of 2 and keeps both
      // height and width larger than the requested height and width.
      while ((halfHeight / inSampleSize) > reqHeight
              && (halfWidth / inSampleSize) > reqWidth) {
        inSampleSize *= 2;
      }
    }

    return inSampleSize;
  }
}
