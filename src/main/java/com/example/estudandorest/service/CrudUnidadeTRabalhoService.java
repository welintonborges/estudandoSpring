package com.example.estudandorest.service;

import com.example.estudandorest.orm.UnidadeTrabalho;
import com.example.estudandorest.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTRabalhoService {

    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private Boolean system = true;

    public CrudUnidadeTRabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
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
        System.out.println("Descrição da unidade de trabalho ");
        String descricao = scanner.next();
        System.out.println("Endereço da sua unidade de trabalho ");
        String endereco = scanner.next();
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Sua unidade de trabalho salvo com sucesso ");
    }

    private void alterar(Scanner scanner){
        System.out.println("Digite Id que deseja alterar");
        int id = scanner.nextInt();
        System.out.println("Digite a descrição que deseja alterar");
        String descricao = scanner.next();
        System.out.println("Digite o endereço  que deseja alterar");
        String endereco = scanner.next();
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Unidade de trabalho alterado com sucesso");

    }

    private void visualizar(){
        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepository.findAll();
        unidadeTrabalhos.forEach(System.out::println);
    }

    private void excluir(Scanner scanner){
        System.out.println("Digite Id que deseja excluir");
        int id = scanner.nextInt();
        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Unidade de trabalho  deletado com sucesso");
    }
}
