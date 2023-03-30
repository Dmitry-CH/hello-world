# hello-world

Starter pet-project.

## Docker

* собрать image

        docker build -t helloworld:latest .

* запустить container

        docker run --name helloworld_app -d -p 3000:3000 helloworld
