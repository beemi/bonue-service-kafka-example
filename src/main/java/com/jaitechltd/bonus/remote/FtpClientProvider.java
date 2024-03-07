package com.jaitechltd.bonus.remote;

import com.jaitechltd.bonus.exception.FtpClientException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@Slf4j
public class FtpClientProvider {

    @Value("${ftp.host}")
    private String ftpHost;
    @Value("${ftp.port}")
    private int ftpPort;
    @Value("${ftp.username}")
    private String ftpUsername;
    @Value("${ftp.password}")
    private String ftpPassword;
    @Value("${ftp.directory}")
    private String ftpDirectory;
    @Value("${ftp.buffer.size}")
    private int ftpBufferSize;
    @Value("${ftp.timeout.ms}")
    private int ftpTimeoutMs;

    public FTPClient createFtpClient() {

        log.debug("Creating FTP client");

        final FTPClient ftpClient = new FTPClient();
        ftpClient.setBufferSize(ftpBufferSize);
        ftpClient.setConnectTimeout(ftpTimeoutMs);
        ftpClient.setDefaultTimeout(ftpTimeoutMs);
        ftpClient.setUseEPSVwithIPv4(true);

        try {
            connect(ftpClient);

            login(ftpClient);

            changeWorkingDirectory(ftpClient);

            return ftpClient;
        } catch (FtpClientException e) {
            throw e;
        } catch (Exception e) {
            throw new FtpClientException("Failed to create FTP client", e);
        }
    }

    private void connect(final FTPClient ftpClient) throws IOException {

        log.debug("Connecting to '{}/{}'", ftpHost, ftpPort);

        final String errorMessage = "Failed to create FTP client - could not connect";

        try {
            ftpClient.connect(ftpHost, ftpPort);

            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new FtpClientException(errorMessage);
            }
        } catch (Exception e) {
            ftpClient.disconnect();
            throw new FtpClientException(errorMessage, e);
        }
    }

    private void login(final FTPClient ftpClient) throws IOException {

        log.debug("Logging in as user '{}'", ftpUsername);

        final String errorMessage = String.format("Failed to create FTP client - login as user '%s' failed",
                ftpUsername);
        try {
            final boolean login = ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.setSoTimeout(ftpTimeoutMs);
            if (!login) {
                ftpClient.disconnect();
                throw new FtpClientException(errorMessage);
            }
        } catch (Exception e) {
            ftpClient.disconnect();
            throw new FtpClientException(errorMessage, e);
        }
    }

    private void changeWorkingDirectory(final FTPClient ftpClient) throws IOException {

        log.debug("Changing remote directory to '{}'", ftpDirectory);

        final String errorMessage = String.format("Failed to create FTP client - could not change to directory '%s'",
                ftpDirectory);
        try {
            final boolean directoryChanged = ftpClient.changeWorkingDirectory(ftpDirectory);
            if (!directoryChanged) {
                ftpClient.disconnect();
                throw new FtpClientException(errorMessage);
            }
            ftpClient.enterLocalPassiveMode();
        } catch (Exception e) {
            ftpClient.disconnect();
            throw new FtpClientException(errorMessage, e);
        }
    }
}
