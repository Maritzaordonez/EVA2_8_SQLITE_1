package edu.tectii.eva2_8_sqlite_1;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    SQLiteDatabase sqlMiBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //abrir la base de datos y crearla si no existe
        sqlMiBD = openOrCreateDatabase("mi_base_datos", MODE_PRIVATE, null);
        //crear una tabla
        try {
            sqlMiBD.execSQL("create table mitabla(" +
            "id integer primary key autoincrement,\n" +
            "nombre text," +
            "apellido text" +
            ");");
        }catch(SQLException e){
            e.printStackTrace();

        }
       /* sqlMiBD.execSQL("insert into mitabla (nombre,apellido)" +
        "values ('Maritza','Ordoñez')");
        sqlMiBD.execSQL("insert into mitabla (nombre,apellido)" +
                "values ('Panchito','Perez')");
        sqlMiBD.execSQL("insert into mitabla (nombre,apellido)" +
                "values ('Fulanito','Picapiedra')");*/
       //sqlMiBD.execSQL("delete from mitabla where id =3");
        Cursor c1 = sqlMiBD.rawQuery("select * from mitabla",null);
        c1.moveToFirst();
        while (!c1.isAfterLast()){
            Toast.makeText(this, c1.getString(c1.getColumnIndex("nombre"))+ " " +
                                       c1.getString(c1.getColumnIndex("apellido")),
                    Toast.LENGTH_SHORT).show();
            c1.moveToNext();
        }
    }
}
