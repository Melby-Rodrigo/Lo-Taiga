package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;

public class ProductMapper {
 
    public static Produto toEntity(ResultSet result) throws SQLException {
        Produto produto = new Produto();
        
        produto.setId(result.getInt("id"));
        produto.setProduto(result.getString("produto"));
        produto.setMarca(result.getString("marca"));
        produto.setQuantidade(result.getInt("quantidade"));
        produto.setValor(result.getFloat("valor"));
        
        return produto;
    }
}
