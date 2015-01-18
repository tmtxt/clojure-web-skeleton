# 1. Vagrant Provision

Everything is set up already for Vagrant, just one command and you're done

```
$ vagrant provision
```

# 2. Production deployment

# Preparation

- Install Ansible on the server
- Create a new user for project, clone the project to the user's home (or
  somewhere with the sufficient permission)
- Create a file for holding the extra vars, for example

extra_vars.yml

```
---
project_user: skeleton
project_dir: /home/skeleton/clojure-web-skeleton
db_password: qeimdjspleks
service_prefix: skeleton
```

- Run the provision with this command (using a user account with sudo
  permission, not the project user)

```
ansible-playbook -i localhost, -c local -e "@/path/to/extra_vars.yml" -K /path/to/clojure-web-skeleton/ansible/main.yml
```

# Variables

You must overwrite these variables on server

- `project_name`: the short unique name of project, default to **skeleton**
- `project_dir`: real path to the project
- `db_password`: password to access database

These variables can be optionally overwritten

- `project_user`: the user to run the project, default to `project_name`
- `db_name`: name of database to create, default to `project_name`
- `db_user`: the user to grant access to database, default to `project_user`
- `db_host`: default to **localhost**
- `service_prefix`: the prefix of the upstart service, default to `project_name`

For other variables, open `ansible/roles` and look into each role, there will be
detailed information about what variables can be overwritten. You can also
adjust the variables for the project in `ansible/group_vars` or `ansible/host_vars`.
