package com.example.estudandorest.service;

import com.example.estudandorest.orm.Funcionario;
import com.example.estudandorest.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {

    Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private FuncionarioRepository funcionarioRepository;

    public RelatorioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Buscar funcionario por nome ");
            System.out.println("0 - Sair");
            System.out.println("1 - Pesquisar por nome");
            System.out.println("1 - Buscar funcionario pelo nome, saalario e data");
            ;

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    pesquisarNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioSalarioData(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    public void pesquisarNome(Scanner scanner) {
        System.out.println("Digite o nome do funcionario");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }

    public void buscaFuncionarioSalarioData(Scanner scanner) {
        System.out.println("Digite o nome do funcionario");
        String nome = scanner.next();

        System.out.println("Digite o data desejada");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter) ;

        System.out.println("Digite o salario para pesquisa");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository.findByPelaDecricao(nome, salario, localDate);
        list.forEach(System.out::println);

        }
}
