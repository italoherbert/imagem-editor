# Simples editor de imagens

!['Imagem Editor'](imagem-editor.png)

Este simples editor de imagens tem funções de filtros gaussiano, pixelização, conversão para tons de cinza, remoção de 
canais de cores, desfazer e refazer, carregar imagens e salvar nos formatos: gif, jpg, png.

## O código fonte

O código fonte está estruturado no pacote principal: "italo.imagemeditor". Dentro deste pacote estão os seguintes 
pacotes e módulos:

* controller: Onde fica o tratamento de eventos. Isto é, os métodos a serem executados a cada evento de interface gráfica tratado;
* desenho: Onde fica o código dos filtros, efeitos e remoção de canais. A estrutura da classe PainelDesenho permite que se possa desfazer ou refazer alguma alteração no gráfico.
* gui: Onde fica o código da interface gráfica swing com a janela principal e o painel de desenho;
* logica: Onde tem apenas a classe utilitária de arquivos de imagem.

O pacote "controller", tem uma interface "Sistema" que tem os métodos de integração dos "controllers", com o restante do sistema.

## Como rodar?

|  :zap:  Atenção: é necessário o Java 11 ou superior instalado   |
|-----------------------------------------------------------------|

| :zap:  É necessário também, o caminho da pasta bin do java (JDK ou JRE) adicionados à variável de ambiente  |
|-------------------------------------------------------------------------------------------------------------|

Para rodar, descompacte o arquivo imagem-editor-1.0.zip, contido na raiz do projeto ou como release do github. Após descompactar, 
use a linha de comandos para posicionar o diretório corrente na pasta compactada e, então, rode o seguinte comando.

```
java -jar imagem-editor-1.0.jar
```
