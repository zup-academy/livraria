# livraria

Executando esse projeto em uma instância da AWS

1- Baixar o repósitório / branch : https://github.com/zup-academy/terraform-ec2-cloudwatch/tree/monitoria-e-tracing-tc3-tl1
2- Acessar https://zup.awsapps.com/start#/
3- Escolher o "ambiente zup-edu-sites-prod" e clicar na opção  "Command line or programmatic access"
4- Copie os três primeiros dados de identificação
5- Dentro do diretório clonado do projeto Terraform, você irá abrir o terminal e irá colar as credenciais que copiou da AWS.
6- Para criar a infra você deverá colocar no terminal o comando
make start
7- Após irá acessar o console da AWS pelo navegador, acessar o serviço EC2 e entrar na máquina identificada por amazonlinux bancodigital ec2
8- clique no ID da instância , após do lado direito superior no botão connect, e depois session manager , opção connect.
9- ao acessar a máquina coloque:
sudo su -
10- em seguida execute :
bash -c 'cd /opt/bancodigital && git checkout monitoria-e-tracing-tc3-tl1'
11- Depois execute :
docker-compose -f /opt/bancodigital/docker/docker-compose.yml up -d

Caso queira parar os containers
docker-compose -f /opt/bancodigital/docker/docker-compose.yml down

Para excluir a infra, você deverá acessar o projeto do Terraform e logar novamente no terminal com suas credenciais e depois colocar o comando
make stop
