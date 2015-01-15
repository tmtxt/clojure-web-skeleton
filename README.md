# Clojure Web skeleton

Skeleton for Clojure web project with Vagrant

# not finished yet...

# 1. Initialize the Development

## Up and running

```
$ git clone --recursive git@github.com:tmtxt/clojure-web-skeleton.git
$ vagrant up
```

## Start the server

```
$ vagrant ssh
$ sudo service skeleton-ring-server start
```

The output log is redirected to `logs/ring-server`

# 2. Deployment

## Preparation

- Install Ansible on the server
- Create a new user, clone the project to the user's home (or somewhere with the
  sufficient permission)
- Create a file for holding the extra vars, for example

extra_vars.yml

```
---
project_user: skeleton
project_dir: /home/skeleton/clojure-web-skeleton
db_password: qeimdjspleks
service_prefix: skeleton
```

- Run the provision with this command

```
ansible-playbook -i localhost, -c local -e "@/path/to/extra_vars.yml" -K /path/to/clojure-web-skeleton/ansible/main.yml
```

## Variables

You must overwrite these variables on server

- project_user: the user to run the project
- project_dir: real path to the project
- db_password: password to access database
- service_prefix: the prefix of the upstart service

These variables can be optionally overwritten

- db_name: name of database to create

For other variables, open `ansible/roles` and look into each role, there will be
detail information about what variables can be overwritten

# 3. Models

Models are defined in `src/app/models`. Model files use
[Korma](http://sqlkorma.com/docs) by default (but you can you whatever ORM that
you want).

To generate a basic model file

```
$ lein run -m core.modelgen --name NAME --table TABLE --primary-key PK
```

- NAME: name of the model to generate (compulsory)
- TABLE: the corresponding table (optionally, default to NAME)
- PK: the primary key column (optionally, default to `id`)
