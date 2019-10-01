package br.com.dasa.mirror.api.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import br.com.dasa.mirror.api.enumeration.TypeFile;

@Service
public class AwsS3Service {

	@Value("${access.key}")
	private String accessKey;

	@Value("${secret.key}")
	private String secretKey;

	@Value("${bucket.name}")
	private String bucketName;

	private String fileBrand = "brand/marca.txt";
	private String fileUnit = "unit/unidade.txt";

	public StringBuilder acessS3Aws(TypeFile typeFile) throws Exception {
		BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
		AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(creds);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(provider).withRegion(Regions.US_EAST_1).build();
		StringBuilder retorno = new StringBuilder();

		if (typeFile.getValue().equals(TypeFile.BRAND.getValue())) {
			retorno = getObjectS3(s3, fileBrand);
		} else if (typeFile.getValue().equals(TypeFile.UNIT.getValue())) {
			retorno = getObjectS3(s3, fileUnit);
		}
		return retorno;
	}

	private StringBuilder getObjectS3(AmazonS3 s3, String file) throws IOException {
		S3Object object = s3.getObject(new GetObjectRequest(bucketName, file));
		StringBuilder retorno = displayTextInputStream(object.getObjectContent());
		return retorno;
	}

	/**
	 * Displays the contents of the specified input stream as text.
	 *
	 * @param input The input stream to display as text.
	 *
	 * @throws IOException
	 */
	public StringBuilder displayTextInputStream(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		StringBuilder retorno = new StringBuilder();
		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			retorno.append(line);
		}
		return retorno;
	}
}
