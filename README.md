# mpes-reuso-basico
Trabalho OSGi das Fábricas

Inicialmente, definimos entre as fábricas as partes divididas do projeto e qual fábrica ficará responsável. São essas:

* Interface e diagrama da solução OSGi. Implementação do primeiro componente(componente de referência) - Fun Factory
  * Componentes: Iluminação pública
* Interface gráfica + componente de segurança - M8
  * Componentes: Limpeza Urbana
* Componente Mapas - F2
  * Componentes: Pavimentação
* Componentes : Arborização e Drenagem - SWCraft

Na reunião de hoje, participaram as fábricas Fun Factory, M8 e SWCraft.

A comunicação fica aberta por email para eventuais dúvidas.

Lembrando que isso foi o que pensamos inicialmente na reunião de hoje. Avaliem e sugestões são sempre bem vindas.

ps. Lembrando que é para o dia 13/05, precisamos que seja entregue no máximo dia 30/04 por motivo de integração e eventuais bugs.

# Setup

* adicionar jars externos ao bundle de servlet: Servlet	API e OSGi	compendium (ver exercício de Servlet com OSGi)
* Importar o Launch configuration na raiz do repositório: Servico Chamado Servlet (OSGi).launch
* Run do framework OSGi com os bundles do projeto 
* executar stop e start dos bundles servlet e tipos de chamados até que fiquem todos disponíveis 
