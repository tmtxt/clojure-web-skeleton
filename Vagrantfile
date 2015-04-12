# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "ubuntu/trusty64"

  # config
  project_name = "skeleton"
  project_user = "vagrant"
  db_port = 54321

  # port forwarding
  config.vm.network :forwarded_port, guest: 8080, host: 9250
  config.vm.network :forwarded_port, guest: 3000, host: 9251
  config.vm.network :forwarded_port, guest: 7888, host: 9252
  config.vm.network :forwarded_port, guest: 9000, host: 9253
  config.vm.network :forwarded_port, guest: db_port, host: 54322

  # provision
  config.vm.provision "ansible" do |ansible|
    ansible.playbook = "ansible/main.yml"

    ansible.extra_vars = {
      # general
      project_name: project_name,
      project_user: project_user,
      project_dir: "/vagrant",

      # db
      db_password: "vagrant",
      db_port: db_port,

      # vagrant specific
      vagrant_env: true
    }
  end
end
