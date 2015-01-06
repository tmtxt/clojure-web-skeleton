# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "ubuntu/trusty64"

  # provision
  config.vm.provision "ansible" do |ansible|
    ansible.playbook = "ansible/main.yml"

    ansible.extra_vars = {
      vagrant_env: true,
      project_dir: "/vagrant",
      db_password: "vagrant"
    }
  end
end
