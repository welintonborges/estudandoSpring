package com.example.estudandorest.service;

import com.example.estudandorest.orm.Cargo;
import com.example.estudandorest.repository.CargoRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;
    private Boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public  void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual ação você quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Excluir");

            int action = scanner.nextInt();
            switch (action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    alterar(scanner);
                    break;
                case 3:
                    visualizar();
                break;
                case 4:
                    excluir(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Cargo salvo com sucesso ");
    }

    private void alterar(Scanner scanner){
        System.out.println("Digite Id que deseja alterar");
        int id = scanner.nextInt();
        System.out.println("Digite a descrição que deseja alterar");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Cargo alterado com sucesso");

    }

    private void visualizar(){
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }

    private void excluir(Scanner scanner){
        System.out.println("Digite Id que deseja excluir");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
        System.out.println("Cargo deletado com sucesso");
    }
}
