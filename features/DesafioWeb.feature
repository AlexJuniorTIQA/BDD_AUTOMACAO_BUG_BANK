# language: pt

Funcionalidade: Transferência entre Contas

@transferenciaComSucesso
Cenario: Realizar Transferência entre Contas
Dado que eu esteja na HomePage do site bugbank e clico no btnRegistar
Quando crio uma conta sem saldo guardando as informacoes
E crio uma segunda conta com saldo guardando as informacoes
E efetuo o login transferindo saldo para primeira conta
Entao valido o resultado de uma transferencia entre ambas as contas

