"# pedidoJohnny Aluno B" 


AlunoB(Pedido)
1)
- Endpoint criarPedido
  -- Ao criar o pedido é preciso CadastrarUsuario (utilizar endpoint do AlunoA)
  -- GravarNovoPedido (utilizar o id do usuário cadastrado na etapa anterior)
- Endpoint para visualizarPedidos (por usuário)


AlunoA(Usuário)
1)
- Endpoint ConsultarPedidosDosUsuarios
  -- ListarUsuarios
  -- ObterPedidosdeCadaUsuario (utilizar endpoint de aluno B de buscar pedidos por usuário)
- Endpoint CadastrarUsuario

Observação!
1) Para saber o ip do computador do colega, utilize o comando ipconfig no CMD
2) Para liberar o acesso aos endpoints precisa colocar a anotação @CrossOrigin ("*") na classe controller.
   exemplo:

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin ("*")
class UsuarioController{
.......
} 