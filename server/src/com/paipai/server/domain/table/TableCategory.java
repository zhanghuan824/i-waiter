package com.paipai.server.domain.table;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum TableCategory {
	Peer,
	Small,
	Medium,
	Large,
	Huge
}
