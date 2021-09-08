package org.ict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// �� �����̳ʿ� �־��ּ���.(��ϵ� ��Ʈ�ѷ��� ������ �۵���)
@Controller
public class MvcController {

	// �⺻�ּ�(localhost:8181)�ڿ� /goA�� ���̸� goA()�޼��� ����
	@RequestMapping(value="/goA")
	// return Ÿ���� String�� ��� ��� �������� ������ �� ����
	public String goA() {
		System.out.println("goA �ּ� ���� ����");
		// ��� �������� views ���� �Ʒ��� A.jsp
		return "A";
	}
	
	// goB�� �������ּ���.
	// ��� �������� B.jsp�Դϴ�.
	@RequestMapping(value="/goB")
	public String goB() {
		System.out.println("goB �ּ� ���� ����");
		return "B";
	}
	
	// goC�� �Ķ���͸� �Է¹������ֵ��� �غ��ڽ��ϴ�.
	@RequestMapping(value="/goC")
	// �ּ� �� ?cNum=��   ���·� ������ ���� ���� ��cNum���� ó���մϴ�.
	// ���� �Ķ���͸� .jsp���Ϸ� �����ϱ� ���ؼ���
	// Model model�� �Ķ���Ϳ� �߰��� �������ݴϴ�.
	public String goC(int cNum, Model model) {
		System.out.println("�ּҷ� ���޹��� �� : " + cNum);
		
		// ���޹��� cNum�� C.jsp�� ����ϴ� ������ �ۼ����ּ���.
		model.addAttribute("cNum", cNum);
		
		return "C";
	}
	
	// goD�� requestParam�� �̿��� ������� �޴� �̸��� ��ġ���� �ʰ� �غ��ڽ��ϴ�.
	@RequestMapping(value="/goD")
	// @RequestParam("��ü�̸�")�� ���� ���ʿ� �����մϴ�.
	// �̷��� �Ǹ� ���� ������ ��� ��ü�̸����� ġȯ�� �޾ƿɴϴ�.
	public String goD(@RequestParam("d") int dNum, Model model) {
		
		System.out.println("d ���������� ������ dNum�� ���� : " + dNum);
		
		// �޾ƿ� ������ D.jsp���� ������ּ���.
		model.addAttribute("dNum", dNum);
		
		return "D";
	}
	
	
	// cToF �޼��带 ����ڽ��ϴ�.
	// ���� �µ��� �Է¹޾� ȭ�� �µ��� �ٲ㼭 ������ִ� ������ �ۼ����ּ���.
	// (ȭ�� -32) / 1.8 = �����Դϴ�.
	// ȭ�� = ���� * 1.8 + 32
	// ���� �̸��� ctof.jsp�Դϴ�.
	// ������ post������� �������������� ����������� �Ѿ������ ����
	@RequestMapping(value="/ctof", method=RequestMethod.POST)
	public String cToF(@RequestParam("cel") int cel, Model model) {
	
		double faren = cel * 1.8 + 32;
		
		model.addAttribute("faren", faren);
		model.addAttribute("cel", cel);
		
		return "ctof";
	}
	
	// ������ �����ϴ� �޼��嵵 ����ڽ��ϴ�.
	// ���� ����������� ���� �ּҸ� �����ϰ� �ϱ� ���ؼ� ������ �ٹ�� ���� ���
	@RequestMapping(value="/ctof", method=RequestMethod.GET)
	public String cToFForm() {
		
		// ctofform�� �̿��� �����µ��� �Է��ϰ� �����ư�� ������
		// ������� ������ ������ �ۼ����ּ���.
		// input �±��� name�Ӽ��� cel�� �ֽø� �ǰ�
		// action�� value�� ���� �ּҰ����� �Ѱ��ֽø� �˴ϴ�.
		
		return "ctofform";
	}
	
	
	// ���� ���� ������� bmi������������ �����ڽ��ϴ�.
	// ���� ����������� �������ֽø� �ǰ�
	// bmi ������ ü�� / (Ű(m) ^ 2) ���� ������ ����Դϴ�.
	@RequestMapping(value="/bmi", method=RequestMethod.GET)
	public String bmiForm() {
		// �� �̵�
		return "bmiform";
	}

	@RequestMapping(value="/bmi", method=RequestMethod.POST)
	public String bmiResult(int height, int weight, Model model) {
		// ���������
		// Ű�� cm�� ���°��� �Ϲ���
		double m = height / 100.0;
		
		// ü���� m�� �������� ����
		double bmi = weight / (m * m);
		
		model.addAttribute("bmi", bmi);
		
		return "bmiresult";
	}
	
	// PathVariable�� �̿��ϸ� url ���ϸ����ε� Ư�� �Ķ���͸� �޾ƿ� �� �ֽ��ϴ�.
	// rest������� url�� ó���Ҷ� �ַ� ����ϴ� ����Դϴ�.
	// /pathtest/����   �� ���� ��ġ�� �� ���� page��� ���������� ����
	@RequestMapping(value="/pathtest/{page}")
	// int page ���ʿ� @PathVariable�� �ٿ��� ó���ؾ� ������
	public String pathTest(@PathVariable int page, Model model) {
		
		System.out.println(page);
		// �޾ƿ� page ������ path.jsp�� �����ּ���.
		// path.jsp���� {path} ������ ��ȸ���Դϴ� ��� ������ �߰� ���ּ���.
		model.addAttribute("page", page);
		return "path";
	}
	
	// ctof ������ PathVariable�� �����ؼ� ������ּ���.
	// ctofpv.jsp �� ����� ������ �˴ϴ�.
	// ���� �µ�(cel)�� url�� �Ϻη� �޵��� ó��
	@RequestMapping(value="/ctof/{cel}")
	public String cToFPv(@PathVariable int cel, Model model) {
		// cel ������ �޾Ƽ�, ȭ���� ���ļ� faren�� ����
		double faren = cel * 1.8 + 32;
		// .jsp(��)�� ����
		model.addAttribute("cel", cel);
		model.addAttribute("faren", faren);
		
		return "ctofpv";
	}
	
	// void Ÿ�� ��Ʈ�ѷ��� Ư¡
	// voidŸ���� return���� �ڿ� �ڷḦ ������ �� ���� ��ŭ
	// view������ �̸��� �׳� url����.jsp �� �ڵ� ���� �ع����ϴ�.
	// ������ �ۼ��� voidŸ������ �ص� ������ �޼���� ������ ���ܼ� �� �Ⱦ��ϴ�.
	@RequestMapping(value="/voidreturn")
	public void voidTest(int num, Model model) {
		System.out.println("void ��Ʈ�ѷ��� ���ϱ����� �ʿ�����ϴ�.");
		// 1. �Ķ���͸� �ƹ��ų� �޾ƿ��� ���Ƿ� �������ּ���.
		// 2. �� �޼��忡 �´� view������ �������ּ���.
		// 3. 1���� ���� �Ķ���͸� 2�� ��µǵ��� �������ּ���.
		model.addAttribute("num", num);
	}
	
	
}
