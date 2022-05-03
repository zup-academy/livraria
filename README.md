# livraria

Executando/ Subindo esse projeto no seu Localhost com as ferramentas de monitoria:

- Primeiramente vamos precisar fazer alguns ajustes, para que os containers se comuniquem localmente.
- Se você usa Linux  aperte as teclas CTRL+ALT+T e digite o comando ifconfig e veja na segunda linha do que foi exibido o número seguido do inet, exemplo:
```shell
br-281ab752f5ac: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 172.20.0.1  netmask 255.255.0.0  broadcast 172.20.255.255
```
O número que você irá considerar será 172.20.0.1
- Se você utiliza Windows, abra o seu shell e coloque o comando ipconfig e pegue o valor conforme indicado a cima.

- Após ter o ip local vamos fazer um ajuste no arquivo prometheus.yml que esta dentro do diretório /docker/monitoramento do projeto de livraria
```yaml
global:
  scrape_interval: 15s
  evaluation_interval: 15s

scrape_configs:
  - job_name: 'livraria'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['livraria:8080']
```
Vamos alterar o target do Job Livraria, onde esta livraria:8080 vamos alterar para utilizar o ip que você mapeou.

Como no exemplo acima encontramos o ip 172.20.0.1 , então ficará:

```yaml
global:
  scrape_interval: 15s
  evaluation_interval: 15s

scrape_configs:
  - job_name: 'livraria'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['172.20.0.1:8080']
```

### 1 - Vamos subir a aplicação e o banco

Acesse a pasta /docker e execute no terminal dentro dessa pasta o comando docker-compose up

### 2 - Vamos subir as ferramentas de monitoria

Acesse a pasta /docker/monitoria e execute no terminal desse diretório o comando docker-compose up

### 3 - Fonte de dados no Grafana

Caso você queira adicionar o banco de dados como uma fonte de dados não utilize localhost no endereço, utilize o nome do serviço do dcoker como db ou prometheus ou o ip da sua máquina que você consultou na etapa inicial.


#### Endereços

Caso queira consultar a documentação dos serviços da aplicação estará no http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
Caso queira se conectar através de client com banco de dados use o endereço localhost:5432
Para acessar o Prometheus use no navegador localhost:9090
Para acessar o Grafana use no navegador localhost:3000