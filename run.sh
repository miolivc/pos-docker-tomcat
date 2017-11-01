
echo "\n    1. CRIANDO EXECUTAVEL DO PROJETO \n"
mvn package

echo "\n    2. GERANDO IMAGEM DOCKER \n"
docker build -t miolivc/pos-app .

echo "\n    3. INCIANDO CONTAINER DOCKER EM http://localhost:8080/app/ \n"
docker run -p 8080:8080 -d --name app miolivc/pos-app

echo "\n    4. ABRINDO APLICACAO NO NAVEGADOR PADRAO \n"
x-www-browser http://localhost:8080/app/ -d -&

