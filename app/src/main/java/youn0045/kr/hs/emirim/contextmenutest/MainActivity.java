package youn0045.kr.hs.emirim.contextmenutest;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button but2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1=(Button)findViewById(R.id.but1);
        img= (ImageView)findViewById(R.id.img1);
        linear = (LinearLayout)findViewById(R.id.linear);
        but2 = (Button)findViewById(R.id.but2);
        registerForContextMenu(but1);
        registerForContextMenu(but2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if(v.getId()==R.id.but1){
            menu.setHeaderTitle("배경색 변경");
            menu.setHeaderIcon(R.drawable.candy);
            menuInflater.inflate(R.menu.menu1,menu);
        }
        if(v.getId()==R.id.but2)
            menu.setHeaderIcon(R.drawable.candy);
            menuInflater.inflate(R.menu.menu2,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch(item.getItemId()){
            case R.id.menu1_item_blue:
                linear.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menu1_item_pink:
                linear.setBackgroundColor(Color.rgb(255,253,233));
                return true;
            case R.id.menu1_item_gray:
                linear.setBackgroundColor(Color.GRAY);
                return true;
            case R.id.menu2_item_rotation:
                img.setRotation(img.getRotation()+90);
                return true;
            case R.id.menu2_item_size:
                img.setScaleX(img.getScaleX()*1.5f);
                img.setScaleY(img.getScaleY()*1.5f);
                return true;
        }
        return false;
    }
}
