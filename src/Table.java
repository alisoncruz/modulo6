import java.util.ArrayList;

public class Table {

    private final int TABLEPADDING = 2;
    private final char SEPERATOR_CHAR = '-';
    private ArrayList<String> headers;
    private ArrayList<ArrayList<String>> table;
    private ArrayList<Integer> maxLength;

    public Table(ArrayList<String> headersIn, ArrayList<ArrayList<String>> content) {
        this.headers = headersIn;
        this.maxLength = new ArrayList<Integer>();

        for (int i = 0; i < headers.size(); i++) {
            maxLength.add(headers.get(i).length());
        }
        this.table = content;
        calcColumnsMaxLength();
    }

    public void printTable() {

        StringBuilder sb = new StringBuilder();
        StringBuilder sbRowSep = new StringBuilder();
        String padder = "";
        String rowSeperator = "";


        for (int i = 0; i < TABLEPADDING; i++) {
            padder += " ";
        }


        for (int i = 0; i < maxLength.size(); i++) {
            sbRowSep.append("|");
            for (int j = 0; j < maxLength.get(i) + (TABLEPADDING * 2); j++) {
                sbRowSep.append(SEPERATOR_CHAR);
            }
        }

        sbRowSep.append("|");

        rowSeperator = sbRowSep.toString();

        sb.append(rowSeperator).append("\n");

        sb.append("|");

        for (int i = 0; i < headers.size(); i++) {
            sb.append(padder);
            sb.append(headers.get(i));

            fillUpWhiteSpaces(sb, i, headers);

            sb.append(padder);
            sb.append("|");
        }

        sb.append("\n").append(rowSeperator).append("\n");

        for (int i = 0; i < table.size(); i++) {
            ArrayList<String> tempRow = table.get(i);
            sb.append("|");
            for (int j = 0; j < tempRow.size(); j++) {
                sb.append(padder);
                sb.append(tempRow.get(j));

                fillUpWhiteSpaces(sb, j, tempRow);

                sb.append(padder);
                sb.append("|");
            }

            sb.append("\n").append(rowSeperator).append("\n");

        }
        System.out.println(sb.toString());
    }

    private void fillUpWhiteSpaces(StringBuilder rowStringBuilder, int rowPos, ArrayList<String> rowContent) {
        for (int k = 0; k < (maxLength.get(rowPos) - rowContent.get(rowPos).length()); k++) {
            rowStringBuilder.append(" ");
        }
    }

    private void calcColumnsMaxLength() {
        for (int i = 0; i < table.size(); i++) {
            ArrayList<String> temp = table.get(i);
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).length() > maxLength.get(j)) {
                    maxLength.set(j, temp.get(j).length());
                }
            }
        }
    }
}
