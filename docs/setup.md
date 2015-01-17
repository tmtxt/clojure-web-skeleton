# Prerequisite

- [VirtualBox](https://www.virtualbox.org/ )
- [Vagrant](https://www.vagrantup.com/ )
- [Ansible](http://www.ansible.com/home )

# Up and running

```
$ git clone --recursive git@github.com:tmtxt/clojure-web-skeleton.git
$ vagrant up
```

# Start the server

- SSH to the VM

```
$ vagrant ssh
```

- Start as upstart service, all the output from stdout will be redirected to
  `logs/ring-server.log`. Use this for production server

```
$ sudo service skeleton-ring-server start
```

- Start it manually, used for development

```
$ lein run
```

By default, the server will run on port 3000, which is forwarded to 9251 in host
machine.
