# FitQA-Spring-Java

## How to build

### Run PostgreSQL and pgAdmin

1. Run docker-compose up in `FitQA-Spring-Java/docker/`
```shell
$ docker-compose up
```

2. Initially, You need to establish a connection.

    2.1 Open `localhost:5050/browser/` in Browser

    2.2 Login pgAdmin as `admin@admin.com/admin`

    2.3 Register server and set name `fitqa`
      ![image](https://github.com/CoCoVo/FitQA-Spring-Java/blob/master/docs/image/readme_1.PNG)

    2.4 Get `fitqa-postgres` IP Address
   
      ```shell
      $ docker container ls
        # like below
      CONTAINER ID   IMAGE                  COMMAND                  CREATED          STATUS          PORTS                           NAMES
      48e42245ae99   dpage/pgadmin4         "/entrypoint.sh"         14 minutes ago   Up 14 minutes   443/tcp, 0.0.0.0:5050->80/tcp   fitqa_pgadmin
      a2481193acdc   postgres:13.1-alpine   "docker-entrypoint.s"   14 minutes ago   Up 14 minutes   0.0.0.0:5432->5432/tcp          fitqa_postgres
      
        # Get postgres container id and write like below
      $ docker inspect a2481193acdc | grep IPAddress
            "SecondaryIPAddresses": null,
            "IPAddress": "",
                    "IPAddress": "192.168.0.3", # -> this is fitqa-postgres IP Address
      ```
   
    2.4 Set `Host name/address` to **fitqa-postgres ip**, `Username` to **root**, `Password` to 
   **root** 

      ![image](https://github.com/CoCoVo/FitQA-Sping-Java/blob/master/docs/image/readme_2.PNG)
   
    2.5 Check out the database

      ![image](https://github.com/CoCoVo/FitQA-Spring-Java/blob/master/docs/image/readme_3.PNG)