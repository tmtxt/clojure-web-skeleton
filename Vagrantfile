# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "ubuntu/trusty64"

  # config
  project_user = "vagrant"

  # port forwarding
  config.vm.network :forwarded_port, guest: 8080, host: 9250
  config.vm.network :forwarded_port, guest: 3000, host: 9251
  config.vm.network :forwarded_port, guest: 7888, host: 9252

  # provision
  config.vm.provision "ansible" do |ansible|
    ansible.playbook = "ansible/main.yml"

    ansible.extra_vars = {
      project_user: project_user,
      vagrant_env: true,
      project_dir: "/vagrant",
      db_password: "vagrant"
    }
  end
end
