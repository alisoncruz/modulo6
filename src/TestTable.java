import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TestTable {
    public static void main(String[] args) {

        Calendar data = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<String> headers = new ArrayList<String>();

        headers.add("");

        data.add(Calendar.DATE,1);
        headers.add(sdf.format(data.getTime()));

        data.add(Calendar.DATE,1);
        headers.add(sdf.format(data.getTime()));

        data.add(Calendar.DATE,1);
        headers.add(sdf.format(data.getTime()));

        data.add(Calendar.DATE,1);
        headers.add(sdf.format(data.getTime()));

        ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();
        ArrayList<String> row1 = new ArrayList<String>();
        row1.add("Alison");
        row1.add("Presente");
        row1.add("Ausente");
        row1.add("Presente");
        row1.add("Presente");
        ArrayList<String> row2 = new ArrayList<String>();
        row2.add("Juliana");
        row2.add("Presente");
        row2.add("Ausente");
        row2.add("Presente");
        row2.add("Presente");

        content.add(row1);
        content.add(row2);

        Table table = new Table(headers,content);
        table.printTable();
    }
}
