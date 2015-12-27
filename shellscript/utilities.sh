
HERE=$(cd "$(dirname "$0")" && pwd)

genererPreTableau() {
  echo "};

  int[] tableauHauteur = {"
}
genererTableauHauteur() {
  hauteur=$(exiftool $1 | grep "Image Height" | tail -c 4)
  echo "$hauteur,"
}

genererInterTableau() {
  echo "};   int[] tableauLargeur = {"
}
genererTableauLargeur() {
    largeur=$(exiftool $1 | grep "Image Width" | tail -c 4)
echo "$largeur,"
}

# ====================================================================

XMLbegin() {
  echo "
  <?xml version=\"1.0\" encoding=\"utf-8\"?>
  <LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"
  android:orientation=\"vertical\" android:layout_width=\"fill_parent\"
  android:layout_height=\"fill_parent\">
  <ScrollView
  android:id=\"@+id/horizontal\"
  android:layout_width=\"wrap_content\"
  android:layout_height=\"fill_parent\"
  android:layout_alignParentBottom=\"true\"
  android:background=\"@color/notthatblack\"
  >

  <TableLayout
  android:id=\"@+id/imgfixe\"
  android:layout_width=\"204dp\"
  android:layout_height=\"fill_parent\"
  android:orientation=\"vertical\">"
}

XMLbouton(){

  echo "

  <Button
  android:id=\"@+id/b_$(basename $1 .png)\"
  android:layout_width=\"36dp\"
  android:layout_height=\"36dp\"
  android:layout_marginLeft=\"12dp\"
  android:layout_marginRight=\"12dp\"
  android:layout_marginTop=\"12dp\"
  android:background=\"@drawable/$(basename $1 .png)\"
  android:scaleType=\"fitCenter\" />  "


}

XMLend() {
  echo "
  </TableLayout>


  </ScrollView>
  </LinearLayout>"
}


genererDebut() {
  echo "
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
  public class LetTheMLGBegin extends ActionBarActivity {

    long[] tableauId = { "
  }

  genererTableau() {
    echo "R.drawable.$(basename $1 .png), "
  }

  genererSuite() {
    echo "};

    int idTableau;
    int dernierIdImage = 0;

    long lastclic = 0;
    int lastId = 0;

    int nombreCourantImage = 0;
    String imageString;
    Button addMLG;
    Button save;
    TextView imagecreated;
    "
  }

  genererVariables() {
    echo "Button $(basename $1 .png); "
  }

  genererApresVariables() {
    echo "

    ImageView tmp;
    SimpleSideDrawer slide;
    SeekBar taille;
    SeekBar rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      getSupportActionBar().hide();


      this.setContentView(R.layout.editor);
      slide = new SimpleSideDrawer(this);
      slide.setLeftBehindContentView(R.layout.dankmemelist);

      Intent intent = getIntent();
      imageString = intent.getStringExtra(\"image\");

      // Bouton IHM
      addMLG = (Button) findViewById(R.id.b_addmontage);
      addMLG.setTextColor(Color.parseColor(\"white\"));
      save = (Button) findViewById(R.id.b_savemontage);
      save.setTextColor(Color.parseColor(\"white\"));
      imagecreated = (TextView) findViewById(R.id.t_imagecreated);
      imagecreated.setTextColor(Color.parseColor(\"white\"));
      afficherMenu();

      // Bouton MLG"}

      genererFindViewById() {
        echo "$(basename $1 .png) = (Button) findViewById(R.id.b_$(basename $1 .png));"
      }

      genererApresFind() {
        echo "

        taille = (SeekBar) findViewById(R.id.taille);
        rotation = (SeekBar) findViewById(R.id.rotation);


        ImageView imgView = (ImageView) findViewById(R.id.imgView);
        imgView.setImageBitmap(BitmapFactory.decodeFile(imageString));


        imgView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            taille.setVisibility(View.INVISIBLE);
            rotation.setVisibility(View.INVISIBLE);
            if (!slide.isClosed()) {
              slide.close();
            }
            afficherMenu();

          }


        });


        save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            imagecreated.setVisibility(View.VISIBLE);
            taille.setVisibility(View.GONE);
            rotation.setVisibility(View.GONE);
            addMLG.setVisibility(View.GONE);
            save.setVisibility(View.GONE);


            captureScreen();

            imagecreated.setVisibility(View.INVISIBLE);

            nombreCourantImage = 0;
            afficherMenu();

          }


        });


        taille.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


          @Override
          public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
            tmp = (ImageView) findViewById(dernierIdImage);
            tmp.requestLayout();
            tmp.getLayoutParams().height = ((2 * tableauHauteur[idTableau] * progresValue) / 100) + 30;
            tmp.getLayoutParams().width = ((2 * tableauLargeur[idTableau] * progresValue) / 100) + 30;
          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {
          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {
          }


        });

        rotation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

          int progress = 0;

          @Override
          public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
            tmp = (ImageView) findViewById(dernierIdImage);
            tmp.requestLayout();
            tmp.setRotation((int) ((progresValue * 3.6) - 180));
          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {
          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {
          }


        });


        addMLG.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            taille.setVisibility(View.INVISIBLE);
            rotation.setVisibility(View.INVISIBLE);
            //cacherMenu();
            slide.toggleDrawer();
          }


        });
        "
      }

      genererSetOnClickListener() {
        echo "
        $(basename $1 .png).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            imageTouchee(R.drawable.$(basename $1 .png));
          }
        });

        "
      }

      genererFin() {
        echo "

      }

      @Override
      public void onBackPressed() {
        if (nombreCourantImage != 0) {
          new AlertDialog.Builder(LetTheMLGBegin.this)
          .setTitle(\"WARNING\")
          .setMessage(\"R U SURE M8 ?THIS CHEF-D-OEUVRE WILL BE DESTROYED\")
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

      void cacherMenu() {
        addMLG.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
      }


      void afficherMenu() {
        addMLG.setVisibility(View.VISIBLE);
        if(nombreCourantImage != 0) save.setVisibility(View.VISIBLE);
        else save.setVisibility(View.INVISIBLE);

          addMLG.bringToFront();
          save.bringToFront();
        }


        void imageTouchee(int id) {

          nombreCourantImage++;
          idTableau = 1;

          for (int idCourant = 0; idCourant < tableauId.length; idCourant++) {
            if (tableauId[idCourant] == id) idTableau = idCourant;
            }

            Log.i(\"Integer id courant: \", Integer.toString(idTableau));

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

            afficherMenu();

            iv.setOnTouchListener(new View.OnTouchListener() {
              @Override
              public boolean onTouch(View arg0, MotionEvent arg1) {

                int currentX = (int) arg1.getRawX();
                int currentY = (int) arg1.getRawY();

                if (arg1.getAction() == MotionEvent.ACTION_MOVE) {

                  iv.setX(currentX - iv.getWidth() / 2);
                  iv.setY(currentY - iv.getHeight() / 2);
                  rotation.bringToFront();
                  taille.bringToFront();
                  lastclic = 0;

                } else if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                  dernierIdImage = iv.getId();
                  taille.setVisibility(View.VISIBLE);
                  rotation.setVisibility(View.VISIBLE);
                  cacherMenu();
                  iv.bringToFront();

                  if (lastId == iv.getId() && System.currentTimeMillis() - lastclic < 500) {
                    iv.setVisibility(View.GONE);
                    taille.setVisibility(View.INVISIBLE);
                    rotation.setVisibility(View.INVISIBLE);
                    if(nombreCourantImage != 0) nombreCourantImage--;
                      afficherMenu();
                    }

                    lastclic = System.currentTimeMillis();


                  } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                    afficherMenu();
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
              + File.separator + \"Camera\" + File.separator + \"MLG_\" +
              now.getDay() + now.getMonth() + now.getYear() + \"_\" + now.getHours() + now.getMinutes() + now.getSeconds() + \".jpg\";
              File file = new File(dest);
              try {
                FileOutputStream stream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                stream.flush();
                stream.close();
                Toast.makeText(getApplicationContext(), \"Saved !\", Toast.LENGTH_SHORT).show();
              } catch (IOException e) {
                Toast.makeText(getApplicationContext(), \"An error occured\", Toast.LENGTH_LONG).show();
              } finally {
                v.setDrawingCacheEnabled(false);
              }
              MediaScannerConnection.scanFile(this, new String[]{file.getPath()}, new String[]{\"image/jpeg\"}, null);
            }
          }
          "
        }

}
