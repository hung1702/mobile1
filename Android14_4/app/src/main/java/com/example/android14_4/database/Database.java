package com.example.android14_4.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android14_4.model.Category;
import com.example.android14_4.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME = "database1.db";
    private static int DATABASE_VERSION = 1;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql="create table category(" +
                "id integer primary key autoincrement," +
                "name text)";
        sqLiteDatabase.execSQL(sql);
        //tao items
        sql="create table items(" +
                "id integer primary key autoincrement," +
                "name text," +
                "cid integer," +
                "price real," +
                "date text," +
                "foreign key(cid) references categories(id))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // insert into category table
    public  void InsertCate(Category c){
        String sql = "insert into category(name)" + "values(?)";
        String[] args = {c.getName()};
        SQLiteDatabase st = getWritableDatabase();
        st.execSQL(sql, args); //void
    }

    // insert into item table
    public  long Insertitem(Item i){
        ContentValues values=new ContentValues();
        values.put("name",i.getName());
        values.put("cid",i.getCategory().getId());
        values.put("price",i.getPrice());
        values.put("date",i.getDate());
        SQLiteDatabase st=getWritableDatabase();
        return st.insert("items",null,values);

    }

    public List<Category> getCates(){
        List<Category> list=new ArrayList<>();
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.query("categories",null,null,null,
                null,null,null);
        while(rs!=null && rs.moveToNext()){
            list.add(new Category(rs.getInt(0),rs.getString(1)));
        }
        return list;
    }

    public List<Item> getItems(){
        List<Item> list=new ArrayList<>();
        String sql="select t.id,t.name,t.price,t.date,c.id,c.name " +
                "from categories c inner join items t " +
                "on (c.id=t.cid)";
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.rawQuery(sql,null);
        while(rs!=null && rs.moveToNext()){
            Category c=new Category(rs.getInt(4),rs.getString(5));
            list.add(new Item(rs.getInt(0),rs.getString(1),rs.getDouble(2),
                    rs.getString(3),c));
        }
        rs.close();
        return list;
    }

}
