Packer installation

    brew install packer@1.6
    packer version


We are currently using the following source AMI:

    Ubuntu 18.04(bionic hvm:ebs-ssd) : ami-068670db424b01e9a : us-west-1

The command to build a new base Docker AMI is the following:

    packer build -var 'region=us-west-1' -var 'clone_regions=us-east-1,us-west-2' -var 'source_ami=ami-068670db424b01e9a' docker_host_image.json

The command to build a new base Consul AMI is the following:

    packer build -var 'region=us-west-1' -var 'clone_regions=us-east-1,us-west-2' -var 'source_ami=ami-068670db424b01e9a' consul_host_image.json
    
The command to build a new base Bastion AMI is the following:

    packer build -var 'region=us-west-1' -var 'clone_regions=us-east-1,us-west-2' -var 'source_ami=ami-068670db424b01e9a' bastion_host_image.json    

Once a new AMI is built the CloudFormation templates should be updated accordingly.
