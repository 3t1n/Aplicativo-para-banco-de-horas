package usuario.app.bancodehoras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tadeu on 04/09/2016.
 */
public class BDcore extends SQLiteOpenHelper {
    private static final String NOME_BD = "teste";
    private static final int VERSAO_BD = 1;
    public static final String HORACHEGADA = " horachegada";
    public static final String HORASAIDA = " horasaida1";
    public static final String MINCHEGADA = " minchegada";
    public static final String MINSAIDA = " minsaida";
    public static final String TABELA = "tabela1";
    public static final String ID = "_id";



    public BDcore(Context ctx){
        super(ctx,  NOME_BD, null,  VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //bd.execSQL("create table usuario(_id integer primary key autoincrement, horachegada text not null, horasaida text not null);");

        //estou setando os comandos sql na variavel sql para depois usar ela sem ter que ficar colocando eles td hr
        String sql = "CREATE TABLE "+TABELA+"(" + ID + "  integer primary key autoincrement, " + HORACHEGADA + " text not null, " + HORASAIDA + " text not null,"
                + MINCHEGADA + " text not null," + MINSAIDA + " text not null" +")";


        db.execSQL(sql); //vai executar os camando sql contidos na var sql

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABELA);
        onCreate(db);

    }
}
