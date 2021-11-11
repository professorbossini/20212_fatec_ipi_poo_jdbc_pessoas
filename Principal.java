import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
        int op;
        do{
            op = Integer.parseInt(
                JOptionPane.showInputDialog(
                    menu
            ));
            switch (op){
                case 1:{
                    String n = JOptionPane.showInputDialog("Nome?");
                    String f = JOptionPane.showInputDialog("Fone?");
                    String e = JOptionPane.showInputDialog("Email?");
                    Pessoa p = new Pessoa (n, f, e);
                    p.inserir();
                    JOptionPane.showMessageDialog(null, "Pessoa cadastrada");
                    break;
                }
                case 2:{
                    String n = JOptionPane.showInputDialog("Nome?");
                    String f = JOptionPane.showInputDialog("Fone?");
                    String e = JOptionPane.showInputDialog("Email?");
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Código?"));
                    Pessoa p = new Pessoa (c, n, f, e);
                    p.atualizar();
                    JOptionPane.showMessageDialog(null, "Pessoa atualizada");
                    break;
                }

            }

        }while (op != 0);
    }
}
