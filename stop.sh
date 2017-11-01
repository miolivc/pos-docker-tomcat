echo "\n    1. PARANDO CONTAINER DOCKER \n"
docker kill app

echo "\n    2. REMOVENDO CONTAINER DOCKER \n"
docker rm app

echo "\n    3. PARANDO IMAGEM DOCKER \n"
docker rmi miolivc/pos-app

echo "\n    4. LIMPANDO PROJETO \n"
mvn clean