package 그래픽문제;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class 영화예매그래픽 {

	public static void main(String[] args) {
		JFrame f = new JFrame("영화예매그래픽버전");
		f.setSize(800,800);
		
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		int[]seat = new int [200];//좌석에 배열을 부여해 0 혹은 1이 들어감
		
		for (int i = 0; i < 200; i++) {//좌석을 200개 생성
			JButton b = new JButton(i + "");//버튼에 차례대로 숫자 입력
			b.addActionListener(new ActionListener() {//좌석을 선택하면 발생하는 이벤트 생성
				
				@Override
				public void actionPerformed(ActionEvent e) {//이벤트
					// TODO Auto-generated method stub
					String s = e.getActionCommand();//버튼에 넣어준 명령을 스트링으로 받아옴
					int index = Integer.parseInt(s);//String을 int로 변환
					seat[index] = 1;//예약을 위한 저장값 1을 넣어줌
					JOptionPane.showMessageDialog(f, index + "번 예약됨");
					//버튼을 비활성화
					b.setEnabled(false);
					b.setBackground(Color.red);
					b.setOpaque(true);
				}
			});
			f.add(b);
		}
		JButton b2 = new JButton("결제하기");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 1.배열의 1을 찾아서 개수를 세라
				// 2.개수 곱하기 만원을 해서 금액을 구하고
				// 3.출력
				int count = 0;//예약된 자리를 누적할 변수
				final int MONEY = 10000;//변하면 안되는 가격을 final로 설정
				String sum = "";
				for (int i = 0; i < seat.length; i++) {//예약이 된 자리인지 비교해줄 반복문
					if(seat[i] == 1) {
						count++;//예약 자리 누적
						sum = sum + i + "번 ";//예약된 자리 표시
					}
				}
				int payment = count * MONEY;
				JOptionPane.showMessageDialog(f, "당신이 결제할 금액은" + payment + "원입니다");
				JOptionPane.showMessageDialog(f, "당신이 예약한 번호는" +	  sum  + "입니다");
			}
		});
		b2.setBackground(Color.yellow);
		f.add(b2);
		
		f.setVisible(true);
	}

}
