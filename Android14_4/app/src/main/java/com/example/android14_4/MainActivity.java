package com.example.android14_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android14_4.database.Database;
import com.example.android14_4.model.Category;
import com.example.android14_4.model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spCate;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCate=findViewById(R.id.spCate);
        txt=findViewById(R.id.txt);
        Database db=new Database(this);
//        db.InsertCate(new Category("Giao duc"));
//        db.InsertCate(new Category("Khoa hoc va cong nghe"));
//        db.InsertCate(new Category("Van nghe"));
        List<Category> list=db.getCates();
        String[] st=new String[list.size()];
        int k=0;
        for(Category i:list){
            st[k++]=i.getId()+"-"+i.getName();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.item,
                st);
        spCate.setAdapter(adapter);
//        db.insertItem(new Item("toan lop 8",12000,"12/5/2000",
//                new Category(1,"")));
//        db.insertItem(new Item("Cong nghe PM",700000,"12/4/2023",
//                new Category(2,"")));
//        db.insertItem(new Item("Nam Cao tu truyen",40000,"1/7/2000",
//                new Category(3,"")));
//        db.insertItem(new Item("Giai thich",15000,"5/4/2007",
//                new Category(2,"")));
//        db.insertItem(new Item("su that mat long",60000,"5/4/2007",
//                new Category(3,"")));


//        db.updateItem(new Item(4,"Dai so tt",2000,"1/2/2000",
//                new Category(2,"")));
//        Item i=db.getItemById(4);
        //db.deleteItem(4);
        // List<Item> items=db.getItems();


//        List<Item> items=db.getItemByfromPricetoPrice(13000,60000);
//        String t="Cac quyen sach:";
//        for(Item i:items){
//            t+="\n"+i.getName()+"-"+i.getCategory().getName();
//        }
//        txt.setText(t);

    }
}