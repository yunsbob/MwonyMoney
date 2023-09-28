import React from "react";
import QrEmogi from "../../../assests/image/QR.png";
import { useNavigate } from "react-router-dom";
import { WhiteBox1 } from "../About/AboutWhilteContainer";
import { Container } from "../About/AboutContainer";
import { EmogiBox } from "../About/AboutEmogi";
import { TextBox, Text } from "../About/AboutText";

function Qr() {
  const navigate = useNavigate();
  const goQr = () => {
    navigate("/Qr");
  };
  return (
    <WhiteBox1 height="90%" onClick={goQr}>
      <Container
        height="100%"
        width="65%"
        flexDirection="column"
        align="start"
        justifyContent="start"
      >
        <TextBox marginL="10%">QR 발급</TextBox>
        <Text>자녀에게</Text>
        <Text>QR코드를 발급해주세요!</Text>
      </Container>
      <Container height="100%" width="35%">
        <EmogiBox height="60%" width="65%" backImg={`${QrEmogi}`} />
      </Container>
    </WhiteBox1>
  );
}

export default Qr;
