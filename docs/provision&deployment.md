# Preparation

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

# Variables

You must overwrite these variables on server

- `project_user`: the user to run the project
- `project_dir`: real path to the project
- `db_password`: password to access database
- `service_prefix`: the prefix of the upstart service

These variables can be optionally overwritten

- `db_name`: name of database to create
- `db_user`: the user to grant access to database, default to `project_user`
- `db_host`: default to **localhost**
- `db_config_path`: path to export json config file of database to (used for
  schemup). Auto omit if not defined

For other variables, open `ansible/roles` and look into each role, there will be
detail information about what variables can be overwritten
