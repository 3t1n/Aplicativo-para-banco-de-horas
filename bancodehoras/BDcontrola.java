package usuario.app.bancodehoras;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tadeu on 04/09/2016.
 */
public class BDcontrola {
    private SQLiteDatabase db; //seta bd com os atributos de sqlitedatabase
    private BDcore banco; //seta banco como BDCORE


    public BDcontrola(Context context){
        banco = new BDcore(context);

    }
    public String insereDado(String horachegada, String horasaida, String minchegada, String minsaida){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BDcore.HORACHEGADA, horachegada);
        valores.put(BDcore.HORASAIDA, horasaida);
        valores.put(BDcore.MINCHEGADA, minchegada);
        valores.put(BDcore.MINSAIDA, minsaida);

        resultado = db.insert(BDcore.TABELA , null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }


}
