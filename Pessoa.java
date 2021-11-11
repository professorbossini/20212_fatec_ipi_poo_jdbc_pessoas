import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;

    public Pessoa (String n, String f, String e){
        this.nome = n;
        this.fone = f;
        this.email = e;
    }

    public Pessoa (int c, String n, String f, String e){
        this(n, f, e);
        this.codigo = c;
    }

    public void inserir(){
        try{
            //1. Especificar o comando SQL
            String sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";
    
            //2. Abrir uma conexão
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.obterConexao();
    
            //3. Pré compilar o comando
            PreparedStatement ps = connection.prepareStatement(sql);
    
            //4. Preencher dados faltantes
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
    
            //5. Executar o comando
            ps.execute();
        }
        catch (Exception e){
          e.printStackTrace();  
        }
    }

    public void atualizar(){
        //try with resources
        try(Connection conexao = new ConnectionFactory().obterConexao()){
            String sql = "UPDATE tb_pessoa SET nome=?, fone=?, email=? WHERE codigo=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // Connection conexao = null;
        // try{
        //     //1. Abrir uma conexão com o SGBD
        //     ConnectionFactory connectionFactory = new ConnectionFactory();
        //     conexao = connectionFactory.obterConexao();
        //     //2. Especificar o comando SQL
        //     //3. Pré compilar o comando
        //     //4. Preencher os dados faltantes
        //     //5. Executar o comando
        //     //6. Fechar a conexão

            
        // }
        // catch (Exception e){
            
        // }
        // finally{
        //     try {
        //         conexao.close();
        //     } catch (SQLException e1) {
        //         // TODO Auto-generated catch block
        //         e1.printStackTrace();
        //     }
        // }
    }
}
