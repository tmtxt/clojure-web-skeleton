# Database System

The default database system installed is PosgreSQL. By default, the provision
will create a database for the project with the name same as `project_name` and
grant access priviledge for `project_user`. `project_user` is a standard Unix
user created during the provision step

# Variables

These are Ansible variables that control the creation process of the database,
mostly are defined in `ansible/group_vars/all`. Some of the are defined in
`Vagrantfile` or `extra_vars.yml` for environment specific properties. See
**Provision** section for more. Usually, except for `db_password`, you don't
need to change these variables

- `db_name`: the name of the database to create, default to `project_name`
- `db_user`: the user to grant access to the database, default to `project_user`
- `db_host`: default to **localhost**
- `db_password`: the password for `db_user` to access to the database, you
  should overwrite this variable
- `vagrant_env`: if set to True, the postgres port will be opened for outside
  access, useful for development when you want to use an external sql client
  (emacs client,...) connect to the database instead of **psql**. Do not set
  this variable to True on production server

# Accessing to the database

After sudo-ing to project user, if `db_name` and `db_user` are all the same with
project_user, you can simply just type `psql` to get access directly to the
database.

In case they are not the same, source the file `pg_env.sh` in project user's
home directory and then type `psql` to access the database.

`pg_env.sh` is an Ansible generated file that contains the information for
connecting to the database. You can use these information to connect from an
external database client from outside through the port 5432 (you need to forward
it to host machine in Vagrantfile)

# Database Migration

By default, the project uses [Schemup](https://github.com/tmtxt/schemup) for
database migration. You can read its documentation on how to declare schema and
table versions. All the files are kept under `schema` folder. The database
`db.json` is generated for you when you run the provision.

When you need to do a database migration, ssh to the project user, source the
virtualenv, change to `schema` directory and run **schemup** command

```
$ . ~/env/bin/activate
$ cd schema
$ schemup commit
Importing migrations/tbl_user.yaml
Importing migrations/tbl_user_image.yaml
```

Of course, you can install and use any migration tool that you want
